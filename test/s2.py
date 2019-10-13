# 找到1-n中的m使得m各位乘积最大
def solution(n):
    max = 0
    for i in range(1, n + 1):
        product = 1
        for j in str(i):
            product *= int(j)
        if product > max:
            max = product
    return max


if __name__ == '__main__':
    print(solution(53))
