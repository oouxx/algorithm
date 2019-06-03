# 台阶问题/斐波那契
"""一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。"""


# method_one
# fib = lambda n : n if n <= 2 else fib(n-1)+fib(n-2)

def fib_recursion(n):
    if n <= 2:
        return n
    else:
        return fib_recursion(n - 1) + fib_recursion(n - 2)
