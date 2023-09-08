from collections import defaultdict

test_string = '''asd asd asd asd as asd asd
asdasdasd asd asd asd
asd asd asd asd asd
'''

dict = defaultdict(list)

for i in [line for line in test_string.splitlines()]:
    x = i.split()
    print(x)
