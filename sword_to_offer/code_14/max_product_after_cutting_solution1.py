# 动态规划求解问题的四个特征：
# ①求一个问题的最优解；
# ②整体的问题的最优解是依赖于各个子问题的最优解；
# ③小问题之间还有相互重叠的更小的子问题；
# ④从上往下分析问题，从下往上求解问题；


# -*- coding:utf-8 -*-
class Solution:
    def cutRope(self, number: int) -> int:
        """剪绳子动态规划版

        :param number:
        :return:
        """
        # write code here
        if number < 2:
            return 0
        if number == 2:
            return 1
        if number == 3:
            return 2

        products = [0] * (number + 1)
        products[0] = 0
        products[1] = 1
        products[2] = 2
        products[3] = 3

        for i in range(4, number + 1, 1):
            sub_max_product = 0
            for j in range(1, i // 2 + 1):
                product = products[j] * products[i - j]
                if sub_max_product < product:
                    sub_max_product = product
                products[i] = sub_max_product

        max_product = products[number]
        del products
        return max_product
