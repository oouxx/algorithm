import random


# 交换两个值
def swap(l, arg1, arg2):
    l[arg1], l[arg2] = l[arg2], l[arg1]


def comparator(l):
    l = sorted(l)
    return l


def generate_random_list(max_size, max_value):
    my_list = []
    random_size = random.randint(1, max_size)
    for i in range(random_size):
        my_list.append(random.randint(-max_value, max_value))
    return my_list


def generate_random_matrix(max_rows, max_cols, max_value):
    random_rows = random.randint(1, max_rows)
    random_cols = random.randint(1, max_cols)
    matrix = []
    for _ in range(random_rows):
        random_list = [random.randint(-max_value, max_value)
                       for __ in range(random_cols)]
        matrix.append(random_list)
    return matrix


def copy_list(l):
    return l[:]


def print_list(l):
    for i in range(len(l)):
        print(l[i], end=' ')


def is_equal(l1, l2):
    if len(l1) != len(l2):
        return False
    for i in range(len(l1)):
        if l1[i] != l2[i]:
            return False
    return True


def test1():
    max_size = 20
    max_value = 100
    my_list = generate_random_list(max_size, max_value)
    print_list(my_list)
    ordered_list = comparator(my_list)
    print('\n')
    print_list(ordered_list)


def test2():
    max_rows = 20
    max_cols = 20
    max_value = 100
    matrix = generate_random_matrix(max_rows, max_cols, max_value)
    print(matrix)


if __name__ == '__main__':
    test2()
