#!/usr/bin/env python
# -*- coding: utf-8 -*-


def get_least_numbers(arr, length, k):
    if not arr or length <= 0 or k <= 0:
        return
    start = 0
    end = length -1
    index = partition(arr, start, end)
    while index != k - 1:
        if index > k - 1:
            end = index -1
            index = partition(arr, start, end)
        if index < k - 1:
            start = index + 1
            index = partition(arr, start, end)
    return arr[:k]


def partition(array, l, r):
    x = array[r]
    i = l - 1
    for j in range(l, r):
        if array[j] <= x:
            i += 1
            array[i], array[j] = array[j], array[i]
    array[i + 1], array[r] = array[r], array[i + 1]
    return i + 1
