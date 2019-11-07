#!/usr/bin/env python
# -*- coding: utf-8 -*-


from itertools import permutations


class Solution:
    def permutation(self, ss):
        if not ss:
            return []
        res = []
        for i in permutations(ss):
            res.append("".join(i))
        res = list(set(res))
        return sorted(res)
