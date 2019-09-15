# -*- coding:utf-8 -*-
# 时间复杂度O(n) 空间复杂度O(1)
# 运行时间：28ms
# 占用内存：5728k


class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        for i in range(numbers.__len__()):
            if numbers[i] != i:
                index = numbers[i]
                if numbers[index] == numbers[i]:
                    duplication[0] = numbers[i]
                    return True
                else:
                    temp = numbers[i]
                    numbers[i] = numbers[index]
                    numbers[index] = temp
        return False
