# -*- coding:utf-8 -*-
class Solution:
    # s 源字符串
    def replace_space(self, s):
        s = s.replace(' ', '%20')
        return s


if __name__ == '__main__':
    solution = Solution()
    result = solution.replace_space('a b c')
    print(result)
