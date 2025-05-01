#include <iostream>
#include <BinaryTree.h>
#include <stack>
using namespace std;

stack<BinaryTree *> s;

void InOrderTraverse(BinaryTree *bt)
{
    BinaryTree *p = bt;
    while (p != NULL || !s.empty())
    {
        if (p)
        {

            s.push(p);
            p = p->lchild;
        }
        else
        {
            s.pop();
            visit(p);
            p = p->rchild;
        }
    }
}

void visit(BinaryTree *bt)
{
    cout << bt->data << endl;
}