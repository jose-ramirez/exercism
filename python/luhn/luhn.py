#coding: utf-8
class Luhn(object):
    def __init__(self, code):
        self._code = code

    def is_valid(self):

        if self._code == '0':
            return False

        invalid_chars = ['a', '-', '£', '$']
        for ch in invalid_chars:
            if ch in self._code:
                return False

        l1 = list(map(int, self._code.replace(' ', '')[::-1]))
        for ix in range(1, len(l1), 2):
            l1[ix] = 2 * l1[ix] if (2 * l1[ix] < 9) else 2 * l1[ix] - 9

        return sum(l1) % 10 == 0