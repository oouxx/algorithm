# -*- coding:utf-8 -*-
# 使用hash表实现
# 时间复杂度O(n) 空间复杂度O(n)
# 25ms	5860K


class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        hash_table = set()
        for i in range(numbers.__len__()):
            if numbers[i] not in hash_table:
                hash_table.add(numbers[i])
            else:
                duplication[0] = numbers[i]
                return True
        return False


# 运行时间：34ms
# 占用内存：5728k
# 非hash表

class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        hash_table = []
        for i in range(numbers.__len__()):
            if numbers[i] not in hash_table:
                hash_table.append(numbers[i])
            else:
                duplication[0] = numbers[i]
                return True
        return False
