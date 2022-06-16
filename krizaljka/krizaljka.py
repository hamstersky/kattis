import sys

words = sys.stdin.readline().strip().split(' ')
for i, char in enumerate(words[0]):
    index = words[1].find(char)
    if index >= 0:
        offset = i
        break

for i, char in enumerate(words[1]):
    if i == index:
        sys.stdout.write(words[0] + '\n')
    else:
        sys.stdout.write(offset * '.' + char + (len(words[0]) - offset - 1) * '.' + '\n')