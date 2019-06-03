def fib_by_recur(n):
    if n == 1 or n == 2:
        return 1
    return fib_by_recur(n - 1) + fib_by_recur(n - 2)


def fib_by_seq(n):
    a = 1
    b = 1
    if n == 1 or n == 2:
        return a
    while (n >= 3):
        a, b = b, a + b
        n -= 1
    return b


if __name__ == '__main__':
    result = fib_by_seq(6)
    print(result)
