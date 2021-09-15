import sys

line = sys.stdin.readline().strip()
result = []

# SOLUTION 1
# smiles = [':)', ';)', ':-)', ';-)']
# for smile in smiles:
#     found = 0
#     while (found >= 0):
#         found = line.find(smile)
#         if found >= 0:
#             line = line[:found] + 'a'*len(smile) + line[found+len(smile):]
#             result.append(found)


# SOLUTION 2
# for i, char in enumerate(line):
#     if char == ":" or char == ";":
#         if i+1 >= len(line):
#             break
#         char = line[i+1]
#         if char == ')':
#             result.append(i)
#         elif char == '-':
#             if i+2 >= len(line):
#                 break
#             char = line[i+2]
#             if char == ')':
#                 result.append(i)

# SOLUTION 3
for i in range(0, len(line)-1):
    small_smile = line[i:i+2]
    big_smile = line[i:i+3]
    if small_smile == ':)' or small_smile == ';)' or big_smile == ':-)' or big_smile == ';-)':
        result.append(i)

sys.stdout.write(' '.join(map(str, result)))
