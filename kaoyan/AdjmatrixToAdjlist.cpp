#include <iostream>
#define VertexNum 100
using namespace std;
// graph.h
typedef struct
{
    int vex[VertexNum];
    int edge[VertexNum][VertexNum];
} GadjMaxtrix;

typedef struct ListNode
{
    int info;
    struct HeadNode head;
    struct ListNode *next;
} GlinkListNode;

typedef struct HeadNode
{
    int vexInfo;
    struct ListNode *first;
} GlinkHeadNode;
// TODO
void adjmatrixtoadjlist(GadjMaxtrix graph1, GlinkHeadNode graph2[])
{
    int n = VertexNum;
    int i, j;
    GlinkListNode *p;
    GlinkHeadNode *h;

    for (i = 0; i <= n - 1; i++)
    {
        graph2[i].first = NULL;
        graph2[i].vexInfo = i;
    }
    for (i = 0; i <= n - 1; i++)
        for (j = 0; j <= n - 1; j++)

            if (graph1.edge[i][j] == 1)
            {
                // 无向图
                // 把i设为headnode
                p = (GlinkListNode *)malloc(sizeof(GlinkListNode));
                p->head = graph2[i];
                p->next = graph2[i].first; //头插法插入节点p
                graph2[i].first = p;
                // 把j设为headnode
                p = (GlinkListNode *)malloc(sizeof(GlinkListNode));
                p->head = graph2[j];
                p->next = graph2[j].first;
                graph2[j].first = p;
            }
}
