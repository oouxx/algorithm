#include <iostream>
using namespace std;
#define SIZE 10

int binarySearch(int arr[], int target);
int main()
{
    int arr[SIZE] = {1, 2, 3,
                     4, 5, 6,
                     7, 8, 9, 10};

    int result = binarySearch(arr, 7);
    if (result != -1)
    {
        cout << "Search successfully"
             << ","
             << "in " << result << endl;
    }
    else
    {
        cout << "Search failed" << endl;
    }
    return 0;
}

// 返回查找到的位置
int binarySearch(int arr[], int target)
{
    int low = 0;
    int high = SIZE - 1;
    int mid = 0;
    while (high >= low)
    {
        mid = (high + low) / 2;
        if (arr[mid] == target)
        {
            return mid;
        }
        else if (arr[mid] < target)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return -1;
}