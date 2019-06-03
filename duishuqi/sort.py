from duishuqi.dui_shu_qi import generate_random_list, comparator


def buddle_sort(my_list):
    if my_list is None:
        return
    length = my_list.__len__()
    if length == 1:
        return my_list
    for i in range(length, 1, -1):
        for j in range(i - 1):
            if my_list[j] > my_list[j + 1]:
                my_list[j], my_list[j + 1] = my_list[j + 1], my_list[j]

    return my_list


def quick_sort_core(my_list, l, r):
    if l < r:
        edge = partition(my_list, l, r)
        quick_sort_core(my_list, l, edge[0] - 1)
        quick_sort_core(my_list, edge[1] + 1, r)


def partition(my_list, l, r):
    num = r
    # 小于p的区域的边界
    left_edge = l - 1
    # 大于p的区域的边界
    right_edge = r + 1
    while l < right_edge:
        if my_list[l] < my_list[num]:
            left_edge += 1
            my_list[l], my_list[left_edge] = my_list[left_edge], my_list[l]
            l += 1
        elif my_list[l] > my_list[num]:
            right_edge -= 1
            my_list[l], my_list[right_edge] = my_list[right_edge], my_list[l]
            l += 1
        else:
            l += 1

    return left_edge + 1, right_edge - 1


def quick_sort(my_list):
    if my_list is None or my_list.__len__() < 2:
        return
    return quick_sort_core(my_list, 0, my_list.__len__() - 1)


if __name__ == '__main__':
    random_list = generate_random_list(100, 10)
    print(random_list)
    quick_sort(random_list)
    print(random_list)
