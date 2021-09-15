import sys

keys = {
    "clank": "a",
    "bong": "b",
    "click": "c",
    "tap": "d",
    "poing": "e",
    "clonk": "f",
    "clack": "g",
    "ping": "h",
    "tip": "i",
    "cloing": "j",
    "tic": "k",
    "cling": "l",
    "bing": "m",
    "pong": "n",
    "clang": "o",
    "pang": "p",
    "clong": "q",
    "tac": "r",
    "boing": "s",
    "boink": "t",
    "cloink": "u",
    "rattle": "v",
    "clock": "w",
    "toc": "x",
    "clink": "y",
    "tuc": "z",
    "whack": " ",
    "bump": "capslock",
    "pop": "delete",
    "dink": "shiftd",
    "thumb": "shiftr" 
}

N = int(sys.stdin.readline().strip())

caps = False
result = []
for _ in range(0, N):
    sound = sys.stdin.readline().strip()
    if keys[sound] == 'capslock' or keys[sound] == 'shiftd' or keys[sound] == 'shiftr':
        caps = not caps
    elif keys[sound] == 'delete':
        if len(result) > 0: result.pop() 
    else:
        key = keys[sound]
        if caps:
            key = key.capitalize()
        result.append(key)

sys.stdout.write(''.join(result))
        