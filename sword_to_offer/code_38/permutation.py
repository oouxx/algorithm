#!/usr/bin/env python
# -*- coding: utf-8 -*-


def permutation(string):
    if string is None:
        return
    begin = 0
    permutation_core(string, begin)


def permutation_core(string, begin):
    if begin == len(string):
        print("".join(string))
    else:
        for i in range(begin, len(string)):
            string[begin], string[i] = string[i], string[begin]
            permutation_core(string, begin + 1)
            string[begin], string[i] = string[i], string[begin]


if __name__ == "__main__":
    string = "abc"
    l = []
    for i in string:
        l.append(i)

    permutation(l)


