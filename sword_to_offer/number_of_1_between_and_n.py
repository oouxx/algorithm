#!/usr/bin/env python
# -*- coding: utf-8 -*-


def number_of_1_between_and_n(n):
    if n <= 0:
        return
    counter = 0
    for i in range(1, n+1):
        if "1" in str(i):
            counter += 1
    return counter


if __name__ == "__main__":
    res = number_of_1_between_and_n(19)
    print(res)
