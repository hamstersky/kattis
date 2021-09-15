from itu.algs4.fundamentals.stack import Stack

def main():
  string = input()
  stack = Stack()
  if (len(string) % 2 != 0) or string[0] == ')' or string[0] == ']':
    print("0")
    return
  for char in range(0, len(string)):
    current_char = string[char]
    if string[char] == '(' or string[char] == '[':
      stack.push(string[char])
    elif not stack.is_empty() and ((string[char] == ')' and '(' == stack.peek()) or (string[char] == ']' and '[' == stack.peek())):
      stack.pop()
    else:
      print("0")
      return
  if stack.is_empty():
    print("1")
  else:
    print("0")

def test():
  string = "([(())])[]"
  stack = Stack()
  if (len(string) % 2 != 0) or string[0] == ')' or string[0] == ']':
    # print("0")
    return
  for char in range(0, len(string)):
    current_char = string[char]
    if string[char] == '(' or string[char] == '[':
      stack.push(string[char])
    elif not stack.is_empty() and ((string[char] == ')' and '(' == stack.peek()) or (string[char] == ']' and '[' == stack.peek())):
      stack.pop()
    else:
      # print("0")
      return
  if stack.is_empty():
    return
    # print("1")
  else:
    return
    # print("0")

def test2():
  string = "([(())])[]"
  brackets = ['()', '{}', '[]'] 
  while any(x in string for x in brackets): 
      for br in brackets: 
          string = string.replace(br, '') 
  return not string 

# test()