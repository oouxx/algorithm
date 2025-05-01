#include <iostream>
#include <algorithm>
using namespace std;

#define MAXSIZE 10
// 基于交换的排序
int main()
{
    int array[MAXSIZE] = {1, 9, 4, 1, 4, 7, 8, 5, 11, 20};
    int n = MAXSIZE;
    for (int i = 0; i < MAXSIZE; i++)
    {
        n--;
        for (int j = 0; j < n; j++)
        {
            if (array[j] < array[j + 1])
            {
                swap(array[j], array[j + 1]);
            }
        }
    }
    for (int i = 0; i < MAXSIZE; i++)
    {
        cout << array[i] << endl;
    }
    return 0;
}