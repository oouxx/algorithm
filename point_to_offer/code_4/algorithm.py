# -*- coding:utf-8 -*-
"""
利用矩阵的有序性，从右上角元素开始查找，若array[i][j]大于target就删除该元素所在列，如果array[i][j]小于target就删除该元素所在行
"""
from duishuqi.dui_shu_qi import generate_random_matrix


class Solution:
    # array 二维列表
    def find(self, target, array):
        if array is None:
            return False
        rows = len(array)
        cols = len(array[0])
        row = 0
        col = cols - 1
        while row <= (rows - 1) and col >= 0:
            if array[row][col] > target:
                col = col - 1
            elif array[row][col] < target:
                row = row + 1
            else:
                return True
        return False


if __name__ == '__main__':
    matrix = generate_random_matrix(20, 20, 100)
    print(matrix)
    solution = Solution()
    is_find = solution.find(-1, matrix)
    print(is_find)
