#include <iostream>
#include <Struct.h>
// 循环队列操作

// 初始化
void InitQueue(SqQueue &queue)
{
    queue.rear = queue.front = 0;
}
// 判断队空
bool isEmpty(SqQueue queue)
{
    if (queue.front == queue.rear)
        return true;
    else
        return false;
}

bool isFull(SqQueue queue)
{
    if ((queue.rear + 1) % MaxSize == queue.front)
        return true;
    else
        return false;
}

// 入队
bool EnQueue(SqQueue &queue, ElemType data)
{
    // 判满
    if (isFull(queue))
    {
        return false;
    };
    queue.data[queue.rear] = data;
    queue.rear = (queue.rear + 1) % MaxSize;
    return true;
}
// 出队
bool DeQueue(SqQueue &queue)
{
    // 判空
    if (isEmpty(queue))
    {
        return false;
    };
    ElemType data = queue.data[queue.front];
    queue.front = (queue.front + 1) % MaxSize;
    return true;
}

// 链队操作
void InitQueue(LinkQueue &queue)
{
    queue.front = queue.rear = (LinkNode *)malloc(sizeof(LinkNode)); //建立头节点
    queue.front->next = NULL;
}

bool isEmpty(LinkQueue queue)
{
    if (queue.front == queue.rear)
    {
        return true;
    }
    else
    {
        return false;
    }
}

void EnQueue(LinkQueue &queue, ElemType data)
{
    LinkNode *node = (LinkNode *)malloc(sizeof(LinkNode));
    node->data = data;
    node->next = NULL;
    queue.rear->next = node;
}

ElemType DeQueue(LinkQueue &queue, ElemType &data)
{
    if (queue.front == queue.rear)
        return false;
    LinkNode *p = queue.front->next;
    data = p->data;
    queue.front->next = p->next;
    if (queue.rear == p)
    {
        queue.rear = queue.front;
    }
    free(p);
    return data;
}