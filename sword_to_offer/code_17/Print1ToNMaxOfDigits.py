def print_1_to_max_of_n_digits(n):
    if n < 0:
        return
    arr = ["0"] * (n + 1)
    arr[n] = '\0'
    for i in range(10):
        arr[0] = str(i)
        print_1_to_max_of_n_digits_recursively(arr, n, 0)
    del arr


def print_1_to_max_of_n_digits_recursively(arr, length, index):
    if index == length - 1:
        print_number(arr)
        return
    for i in range(10):
        arr[index + 1] = str(i)
        print_1_to_max_of_n_digits_recursively(arr, length, index + 1)


def print_number(arr):
    is_beginning0 = True
    length = len(arr)
    for i in range(length):
        if is_beginning0 and arr[i] != "0":
            is_beginning0 = False
        if not is_beginning0:
            print(arr[i], end="")
    print("\t")


if __name__ == "__main__":
    print_1_to_max_of_n_digits(4)
