#!/usr/bin/env python
# -*- coding: utf-8 -*-


def all_combitions(ss):
    if ss is None:
        return []
    res = []
    for i in range(1, len(ss)+1):
        comb = all_combitions_core(ss, i, "")
        res.append(comb)
    return res


def all_combitions_core(ss, m, string):
    if m == len(ss):
        return [ss]
    if ss[0] in m:
        string += ss[0]
        string = all_combitions_core(ss[1:], m[1:], string)
    else:
        string = all_combitions_core(ss[1:], m, string)
    return string


if __name__ == "__main__":
    res = all_combitions("abc")
    print(res)
