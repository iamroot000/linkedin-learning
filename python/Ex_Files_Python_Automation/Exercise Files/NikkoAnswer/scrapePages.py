import requests
from bs4 import BeautifulSoup

url = 'https://scrapingclub.com/exercise/list_basic/'
response = requests.get(url)
soup = BeautifulSoup(response.text, 'lxml')
items = soup.find_all('div', class_='w-full rounded border')
count = 1
for i in items:
    item_name = i.find('h4').text
    item_price = i.find('h5').text
    print('%d) Price: %s, Item Name: %s' % (count, item_price, item_name.strip()))
    count = count + 1
pages = soup.find('nav', class_='pagination')
urls = []
links = pages.find_all('a')
for link in links:
    pageNum = int(link.text) if link.text.isdigit() else None
    if pageNum is not None:
        x = str(link.get('href')).split('/')
        urls.append(x[3])
for i in urls:
    new_url = url + i
    response = requests.get(new_url)
    soup = BeautifulSoup(response.text, 'lxml')
    items = soup.find_all('div', class_='w-full rounded border')
    for i in items:
        item_name = i.find('h4').text
        item_price = i.find('h5').text
        print('%d) Price: %s, Item Name: %s' % (count, item_price, item_name.strip()))
        count = count + 1
