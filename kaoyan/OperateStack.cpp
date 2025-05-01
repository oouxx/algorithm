#include <iostream>
#include <Struct.h>
using namespace std;

// 初始化顺序栈
bool InitSqStack(SqStack &sqStack)
{
    sqStack.top = -1;
    return true;
}
// 进栈
bool PushSqStack(SqStack &sqStack, ElemType data)
{
    if (sqStack.top == MaxSize - 1)
    {
        return false;
    }
    sqStack.stack[++sqStack.top] = data;
    return true;
}
// 出栈
ElemType PopSqStack(SqStack &sqStack)
{
    if (sqStack.top == -1)
    {
        return false;
    }
    ElemType data = sqStack.stack[sqStack.top--];
    return data;
}
bool ClearSqStack(SqStack &sqStack)
{
    sqStack.top = -1;
    return true;
}

// TODO
bool InitLinkStack(LinkStack &linkStack)
{
}
// TODO
bool PushLinkStack(LinkStack &linkStack, ElemType data)
{
}