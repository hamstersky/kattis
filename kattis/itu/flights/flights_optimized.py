import sys
from itu.algs4.searching.red_black_bst import RedBlackBST
from itu.algs4.searching.seperate_chaining_hst import SeparateChainingHashST

class HT(SeparateChainingHashST):
    def __init__(self):
        super().__init__()

    def _hash(self, flight):
        h, m, s = flight.split(":")
        h, m, s = int(h), int(m), int(s)
        m += h * 60
        s += m * 60
        return s

class Flights:


    def __init__(self):
        self.bst = RedBlackBST()
        self.ht = SeparateChainingHashST()


    def do(self, operation, args):
        operations = {
            "cancel": self._cancel,
            "delay": self._delay,
            "reroute": self._reroute,
            "destination": self._destination,
            "next": self._next,
            "count": self._count
        }
        op = operations.get(operation, self._add)
        if op == self._add:
            self._add(operation, args[0])
        else:
            result = op(*args)
            if result is not None: print(result) 


    def _add(self, time, dest):
        self.bst.put(time, dest)
        self.ht.put(time, dest)


    def _cancel(self, flight):
        self.bst.delete(flight)
        self.ht.delete(flight)


    def _delay(self, flight, d):
        dest = self.ht.get(flight)
        if dest is not None:
            time = Flights._format_time(flight, d)
            self.bst.delete(flight)
            self.ht.delete(flight)
            self.bst.put(time, dest)
            self.ht.put(time, dest)


    def _reroute(self, flight, new_dest):
        self.bst.put(flight, new_dest)
        self.ht.put(flight, new_dest)


    def _destination(self, flight):
        dest = self.ht.get(flight)  
        return dest if dest is not None else print("-")


    def _next(self, flight):
        try:
            time = self.bst.ceiling(flight)
        except:
            time = self.bst.ceiling("00:00:00")
        dest = self.bst.get(time)
        return f'{time} {dest}'


    def _count(self, time1, time2):
        return self.bst.size_range(time1, time2)

    @staticmethod
    def _hash(flight):
        h, m, s = flight.split(":")
        h, m, s = int(h), int(m), int(s)
        m += h * 60
        s += m * 60
        return s

    @staticmethod
    def _format_time(time, d):
        h, m, s = time.split(":")
        h, m, s = int(h), int(m), int(s)
        s += int(d)
        if s >= 60:
            m += s // 60
            s = s % 60
        if m >= 60:
            h += m // 60
            m = m % 60
        if h >= 24:
            h = h % 24
        if h < 10:
            h = f'0{h}'
        if m < 10:
            m = f'0{m}'
        if s < 10:
            s = f'0{s}'
        return f'{h}:{m}:{s}'


def main():
    f = Flights()
    for i, line in enumerate(sys.stdin):
        # Skip first line
        if i != 0:
            operation, *args = line.split()
            f.do(operation, args)


if __name__ == "__main__":
    main()

