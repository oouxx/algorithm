# -*- coding:utf-8 -*-
# 先排序再从头到尾扫描
# 时间复杂度O(nlogn）， 空间复杂度O(1)
# 使用牛客网代码模板
# 22ms	5652K


class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        # Timsort, 平均时间复杂度为O(nlogn)
        numbers.sort()
        for i in range(numbers.__len__()-1):
            if numbers[i] == numbers[i+1]:
                duplication[0] = numbers[i]
                return True
        return False
