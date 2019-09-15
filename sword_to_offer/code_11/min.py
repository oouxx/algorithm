"""
旋转数组的最小元素
思路：利用数组的有序性，使用两个指针卡住边界进行查找，循环终止的条件是两个指针相邻，这时第一个指针指向数组中最大的元素，第二个指针指向数组中最小的元素
"""

# 常规解法
# 需要考虑完全正序和完全逆序两种情况


class Solution:
    def minNumberInRotateArray(self, rotateArray):
        array_length = len(rotateArray)
        for i in range(array_length - 2):
            if rotateArray[i] <= rotateArray[i + 1]:
                continue
            else:
                return rotateArray[i + 1]
        return rotateArray[0] if rotateArray[array_length - 1] > rotateArray[0] else rotateArray[1]
