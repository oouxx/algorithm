import sys


def demo():
    a = []
    print(sys.getrefcount(a))
    b = []
    print(sys.getrefcount(b))
    a.append(b)
    b.append(a)
    print(sys.getrefcount(a))
    print(sys.getrefcount(b))
    a.append(a)
    a.append(1)
    b.append(1)
    print(a)
    print(sys.getrefcount(a))
    # del a
    # print(sys.getrefcount(a))
    # del b
    # print(sys.getrefcount(b))


if __name__ == '__main__':
    demo()
