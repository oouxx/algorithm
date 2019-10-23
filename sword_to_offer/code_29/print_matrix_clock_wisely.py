#!/usr/bin/env python
# -*- coding: utf-8 -*-


def print_matrix_clock_wisely(matrix):
    rows = len(matrix)
    cols = len(matrix[0])
    row = 0
    col = 0
    while 0 <= row < rows and 0 <= col < cols:
        while 0 <= row < rows and 0 <= col < cols:
            print(matrix[row][col], end=",")
            col += 1
        row += 1
        col -= 1
        while 0 <= row < rows and 0 <= col < cols:
            print(matrix[row][col], end=",")
            col -= 1
        row += 1
        col += 1


if __name__ == "__main__":
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print_matrix_clock_wisely(matrix)

