passFile = open('passFile.txt', 'w')
failFile = open('failFile.txt', 'w')
files = open('inputFile.txt', 'r')
count = 0
for file in files.readlines():
    file_split = file.split()
    if file_split[2] == 'P':
        passFile.write(file)
    else:
        failFile.write(file)
files.close()
passFile.close()
failFile.close()