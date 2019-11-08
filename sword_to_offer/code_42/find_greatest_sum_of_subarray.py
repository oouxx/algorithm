#!/usr/bin/env python
# -*- coding: utf-8 -*-


def find_greatest_sum_of_subarray(arr, length):
    if not arr or length <= 0:
        return 0
    cur_num = 0
    greatest_num = 0
    for i in range(length):
        if cur_num <= 0:
            cur_num = arr[i]
        else:
            cur_num += arr[i]
        if cur_num > greatest_num:
            greatest_num = cur_num
    return greatest_num

