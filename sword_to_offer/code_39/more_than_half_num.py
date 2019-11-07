#!/usr/bin/env python
# -*- coding: utf-8 -*-


def more_than_half_num(arr, length):
    if arr is None or length <= 0:
        return 0
    mid = length >> 1
    start = 0
    end = length - 1
    index = partition(arr, length, start, end)
    while index != mid:
        if index > mid:
            end = index - 1
            index = partition(arr, length, start, end)
        else:
            start = index + 1
            index = partition(arr, length, start, end)
    result = arr[mid]
    if check_more_than_half(arr, length, result):
        return result
    return 0


def partition(array, length, l, r):
    x = array[r]
    i = l - 1
    for j in range(l, r):
        if array[j] <= x:
            i += 1
            array[i], array[j] = array[j], array[i]
    array[i + 1], array[r] = array[r], array[i + 1]
    return i + 1


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


if __name__ == "__main__":
    arr = [1, 2, 2, 2, 3]
    res = more_than_half_num(arr, len(arr))
    print(res)
