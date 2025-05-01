#include <iostream>
using namespace std;
#define MaxSize 100
typedef int ElemType;
// 顺序栈
typedef struct
{
    ElemType stack[MaxSize];
    int top;
} SqStack;
// 链栈
typedef struct LinkNode
{
    ElemType data;
    struct LinkNode *next;

} * LinkStack;

typedef struct
{
    ElemType data[MaxSize];
    int front, rear;
} SqQueue;

typedef struct
{
    ElemType data;
    struct LinkNode *next;
} LinkNode;

typedef struct
{
    LinkNode *front, *rear;
} LinkQueue;

struct TreeNode
{
    ElemType val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL){};
};