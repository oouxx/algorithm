#!/usr/bin/env python
# -*- coding: utf-8 -*-

import heapq


def get_least_numbers_with_heap(arr, k):
    res = heapq.nsmallest(k, arr)
    print(res)


if __name__ == "__main__":
    arr = [2, 3, 4, 5, 1, 4, 9]
    heapq.heapify(arr)
    get_least_numbers_with_heap(arr, 3)
