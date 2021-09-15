import sys

N = int(sys.stdin.readline().strip())

tleft = [x for x in range(1, 9)]
tright = [x for x in range(1, 9)]
bleft = [x for x in range(1, 9)]
bright = [x for x in range(1, 9)]

for i in range(0, N):
    tooth = sys.stdin.readline().strip()
    if tooth[0] == '+':
        if tooth[3] == 'm':
            tleft.remove(tooth[1])
        else:
            tleft = []
    elif tooth[0] == '-':
        if tooth[3] == 'm':
            bleft.remove(tooth[1])
        else:
            bleft = []
    else:
        if tooth[1] == '+':
            if tooth[3] == 'm':
                tright.remove(tooth[1])
            else:
                tright = []
        else:
            if tooth[3] == 'm':
                bright.remove(tooth[1])
            else:
                bright = []

