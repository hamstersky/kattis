import sys

N = int(sys.stdin.readline().strip())
temps = map(int, sys.stdin.readline().strip().split(' '))
sys.stdout.write(str(sum(x < 0 for x in temps)))