def t1(a):
  print("7")

def t2(a):
  if a[0] > a[1]:
    print("Bigger")
  elif a[0] < a[1]:
    print("Smaller")
  else:
    print("Equal")

def t3(a):
  ordered = sorted(a[:3])
  print(ordered[1])

def t4(a):
  print(sum(a))

def t5(a):
  print(sum(x for x in a if x % 2 == 0))

def t6(a):
  letters = [chr(97 + x % 26) for x in a]
  print("".join(letters))

def t7(a):
  i = 0
  visited = [False]*(len(a))
  while True:
    visited[i] = True
    i = a[i]
    if i > len(a)-1:
      print("Out")
      break
    elif i == len(a)-1:
      print("Done")
      break
    elif visited[i]:
      print("Cyclic")
      break

def main():
  n, t = input().split()
  a = [int(x) for x in input().split()]

  switch = {
    "1": t1,
    "2": t2,
    "3": t3,
    "4": t4,
    "5": t5,
    "6": t6,
    "7": t7
  }

  switch.get(t)(a)

main()