#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Time complexity O(N)
created by wxx
"""


def more_than_half_num(arr, length):
    if arr is None or length <= 0:
        return
    result = arr[0]
    times = 0
    for i in range(length):
        if result == arr[i]:
            times += 1
        else:
            times -= 1
        if times < 0:
            result = arr[i]
    if check_more_than_half(arr, length, result):
        return result
    else:
        result = 0
    return result


def check_more_than_half(arr, length, number):
    if arr is None or length <= 0:
        return False
    times = 0
    for i in range(length):
        if arr[i] == number:
            times += 1
    if times * 2 >= length:
        return True
    else:
        return False

