# 把一个整数减去1，再与原来的数做与运算，会把原来的数最右边的1变为0


class Solution(object):
    def number_of_1(self, n):
        count = 0
        while n:
            count = count + 1
            n = (n - 1) & n

        return count

