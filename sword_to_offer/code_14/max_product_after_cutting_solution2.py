class Solution:
    def cutRope(self, number: int) -> int:
        """剪绳子贪婪算法版

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
        # 尽可能多地减去长度为3的绳子段
        times_of_3 = number // 3
        # 当绳子的长度为4时减去长度为2的两段

        if number - times_of_3 * 3 == 1:
            times_of_3 -= 1
        times_of_2 = (number - times_of_3 * 3) / 2
        return (3**times_of_3)*(2**times_of_2)
