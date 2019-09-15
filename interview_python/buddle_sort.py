# 冒泡从小到大排序
def buddle_sort(alist):
    list_length = len(alist)
    for _ in range(list_length - 1):
        for i in range(list_length - 1 - _):
            if alist[i] > alist[i + 1]:
                alist[i], alist[i + 1] = alist[i + 1], alist[i]
    print(alist)


buddle_sort([3, 2, 1])

