#!/usr/bin/env python
# -*- coding: utf-8 -*-


def verify_sequence_of_bst(onelist, l, r):
    if r - l >= 1:
        return True
    result = False
    node = onelist[r]
    index = l
    while index < r - 1:
        if onelist[index] < node <= onelist[index + 1]:
            result = True
            break
        else:
            index += 1
    if result:
        result = verify_sequence_of_bst(onelist[:index + 1], 0, index)
    if result:
        result = verify_sequence_of_bst(onelist[index + 1:r], index + 1, r)
    return result


if __name__ == "__main__":
    re = verify_sequence_of_bst([5, 7, 6, 9, 11, 10, 8], 0, 6)
    print(re)
