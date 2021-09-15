import sys
from itu.algs4.searching.red_black_bst import RedBlackBST

def main():
    bst = RedBlackBST()
    for i, line in enumerate(sys.stdin):
        if i != 0:
            operation, arg1, *arg2 = line.split()
            if arg2:
                arg2 = arg2[0]
            if operation == "cancel":
                bst.delete(arg1)
            elif operation == "delay":
                dest = bst.get(arg1)
                if dest is not None:
                    time = _delay(arg1, arg2)
                    bst.delete(arg1)
                    bst.put(time, dest)
            elif operation == "reroute":
                bst.put(arg1, arg2)
            elif operation == "destination":
                destination = bst.get(arg1)
                if destination is not None:
                    print(destination)
                else:
                    print("-")
            elif operation == "next":
                time = bst.ceiling(arg1)
                dest = bst.get(time)
                print(f'{time} {dest}')
            elif operation == "count":
                print(bst.size_range(arg1, arg2))
            else:
                bst.put(operation, arg1)

def _delay(time, d):
    h, m, s = time.split(":")
    h, m, s = int(h), int(m), int(s)
    s += int(d)
    if s >= 60:
        m = s // 60
        s = s % 60
    if m >= 60:
        h += m // 60
        m = s % 60
    if h >= 24:
        h = h % 24
    if h < 10:
        h = f'0{h}'
    if m < 10:
        m = f'0{m}'
    if s < 10:
        s = f'0{s}'
    return f'{h}:{m}:{s}'


if __name__ == "__main__":
    main()


