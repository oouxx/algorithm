# 递归版
def fib_recursive(n):
    if n < 3:
        return 1
    return fib_recursive(n - 1) + fib_recursive(n - 2)


# 动态规划版
def fib_dp(n):
    a = 1
    b = 1
    while n >= 3:
        a, b = b, a + b
        n -= 1
    return b


if __name__ == '__main__':
    import time

    start = int(time.time())
    fib_recursive(40)
    end = int(time.time())
    print("使用递归版本花了{}ms".format(end - start))

    start = int(time.time())
    fib_dp(10000)
    end = int(time.time())
    print("使用动态规划版本花了{}ms".format(end - start))

    # 这性能差距太可怕了!!!
