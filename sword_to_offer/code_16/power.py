class Solution(object):
    def power(self, base, exponent):
        if base == 0 and exponent < 0:
            raise Exception("exponent cannot less than zero when base equal zero")
        if base == 0:
            return 0
        abs_exponent = abs(exponent)
        if exponent == 0:
            return 1
        if abs_exponent == 1:
            if exponent > 0:
                return base
            else:
                return 1 / base
        if abs_exponent >= 2:
            result = 1
            for i in range(abs_exponent):
                result *= base
            if exponent > 0:
                return result
            else:
                return 1 / result

    def power2(self, base, exponent):
        if exponent == 0:
            return 1
        if exponent == 0:
            return base

        result = self.power2(base, exponent >> 1)
        result *= result
        if (exponent & 0x1 == 1):
            result *= base

        return result


if __name__ == '__main__':
    s = Solution()
    print(s.power2(2, 3))
