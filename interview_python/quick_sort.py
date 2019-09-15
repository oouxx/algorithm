# quick_sort = lambda array: array if len(array) <= 1 else quick_sort(
#     [item for item in array[1:] if item <= array[0]]) + [array[0]] + quick_sort(
#     [item for item in array[1:] if item > array[0]])
#
#
# def quick_sort(array, left, right):
#     if left >= right:
#         return
#     low = left
#     high = right
#     key = array[low]
#     while left < right:
#         while left < right and array[right] > key:
#             right -= 1
#         array[left] = array[right]
#         while left < right and array[left] <= key:
#             left += 1
#         array[right] = array[left]
#     array[right] = key
#     quick_sort(array, low, left - 1)


def quick_sort(array, l, r):
    if l < r:
        p = partition(array, l, r)
        quick_sort(array, l, p - 1)
        quick_sort(array, p + 1, r)


def partition(array, l, r):
    x = array[r]
    i = l - 1
    for j in range(l, r):
        if array[j] <= x:
            i += 1
            array[i], array[j] = array[j], array[i]
    array[i + 1], array[r] = array[r], array[i + 1]
    return i + 1


# def quick_sort(array, l, r):
#     if l >= r:
#         return
#     stack = []
#     stack.append(l)
#     stack.append(r)
#     while stack:
#         low = stack.pop(0)
#         high = stack.pop(0)
#         if high - low <= 0:
#             continue
#         x = array[high]
#         i = low - 1
#         for j in range(low, high):
#             if array[j] <= x:
#                 i += 1
#                 array[i], array[j] = array[j], array[i]
#         array[i + 1], array[high] = array[high], array[i + 1]

array = [3, 2, 4, 1]
quick_sort(array, 0, 3)
print(array)
