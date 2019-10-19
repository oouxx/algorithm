#!/usr/bin/env python
# -*- coding: utf-8 -*-


def ReorderOddEven(alist, length):
    if not alist:
        return
    l_pointer = 0
    r_pointer = length - 1
    while l_pointer < r_pointer:
        while l_pointer < r_pointer and not is_even(alist[l_pointer]):
            l_pointer += 1
        while l_pointer < r_pointer and is_even(alist[r_pointer]):
            r_pointer -= 1

        if l_pointer < r_pointer:
            alist[l_pointer], alist[r_pointer] = alist[r_pointer], alist[l_pointer]
    return alist


def is_even(num):
    return num % 2 == 0


if __name__ == "__main__":
    my_list = [1, 2, 3, 4, 5]
    r = ReorderOddEven(my_list, len(my_list))
    print(r)
