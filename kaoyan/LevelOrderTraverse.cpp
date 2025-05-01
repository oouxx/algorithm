#include <iostream>
#include <BinaryTree.h>
#include <queue>
using namespace std;

queue<BinaryTree *> q;
void LevelOrderTraverse(BinaryTree *bt)
{
    if (bt == nullptr)
        return;
    BinaryTree *p = bt;
    int deepth = 0;
    q.push(p);
    while (!q.empty())
    {
        BinaryTree *front = q.front();
        cout << front->data << endl;
        q.pop();
        if (front->lchild != nullptr)
        {
            q.push(front->lchild);
        }
        if (front->rchild != nullptr)
        {
            q.push(front->rchild);
        }
    }
}