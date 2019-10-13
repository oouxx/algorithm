def quick_sort(arr, l, r):
    if len(arr) == 1 or not arr:
        return arr
    quick_sort_core(arr, l, r)
    return arr


def quick_sort_core(arr, l, r):
    if l < r:
        p = partition(arr, l, r)
        quick_sort_core(arr, l, p[0])
        quick_sort_core(arr, p[1], r)


def partition(arr, l, r):
    ll = l
    node = arr[l]
    i = l - 1
    j = r + 1
    while l < j:
        if arr[l] < node:
            i += 1  
            l += 1
        elif arr[l] > node:
            j -= 1
            arr[l], arr[j] = arr[j], arr[l]
        else:
            l += 1
    arr[ll], arr[i+1] = arr[i+1], arr[ll]
    return i, j


if __name__ == "__main__":
    arr = [3]
    result = quick_sort(arr, 0, len(arr) - 1)
    print(result)
    