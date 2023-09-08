from collections import defaultdict

myList = list(range(100))
newList = [i for i in [x for x in myList if x % 5 == 0] if i % 10 == 0]
# print(newList)

newDict = defaultdict(list)
newDict['a'].append('AAAA')

print(newDict)