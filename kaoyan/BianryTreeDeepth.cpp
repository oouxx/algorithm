#include <iostream>
#include <BinaryTree.h>
#include <queue>
using namespace std;

queue<BinaryTree *> q;
int TreeDepth(BinaryTree *bt)
{
    if (bt == NULL)
        return 0;
    BinaryTree *p = bt;
    int depth = 0;
    q.push(p);
    while (!q.empty())
    {
        depth++;
        int count = 0;
        int size = q.size();
        while (count < size) // 弹出当前层节点
        {

            BinaryTree *front = q.front();
            cout << front->data;
            q.pop();
            count++;
            if (front->lchild != NULL)
            {
                q.push(front->lchild);
            }
            if (front->rchild != NULL)
            {
                q.push(front->rchild);
            }
        }
    }
    return depth;
}
// 递归方法求二叉树深度
int GetTreeDepth(BinaryTree *bt)
{
    if (bt == NULL)
    {
        return 0;
    }
    int leftTreeDepth = GetTreeDepth(bt->lchild);
    int rightTreeDepth = GetTreeDepth(bt->rchild);
    int result = max(leftTreeDepth, rightTreeDepth) + 1;
    return result;
}