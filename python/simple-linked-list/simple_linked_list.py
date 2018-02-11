class Node(object):
    def __init__(self, value):
        self._value = value
        self._next = None

    def value(self):
        return self._value

    def next(self):
        return self._next


class LinkedList(object):
    def __init__(self, values=[]):
        self._values = values
        self.nodes = [Node(values[i]) for i in range(len(values))]
        for i in range(len(values) - 1, 0, -1):
            self.nodes[i]._next = self.nodes[i - 1]

    def __len__(self):
        return len(self.nodes)

    def __iter__(self):
        return iter([n.value() for n in self.nodes[::-1]])

    def head(self):
        if len(self.nodes) == 0:
            raise EmptyListException("empty list")
        return self.nodes[-1]

    def push(self, value):
        n = Node(value)
        if len(self.nodes) > 0:
            self.nodes[-1]._next = n
        self.nodes.append(n)

    def pop(self):
        if len(self.nodes) == 0:
            raise EmptyListException("empty list")
        return self.nodes.pop().value()

    def reversed(self):
        return iter(self._values)


class EmptyListException(Exception):
    pass
