#!/usr/bin/env python
# -*- coding: utf-8 -*-


class ComplexListNode(object):
    def __init__(self, val=None, next=None, sibling=None):
        self.val = val
        self.next = next
        self.sibling = sibling


def clone_node(head):
    pnode = head
    while pnode:
        pcloned = ComplexListNode()
        pcloned.val = pnode.val
        pcloned.next = pnode.next
        pcloned.sibling = pnode.sibling

        pnode.next = pcloned
        pnode = pcloned.next


def connect_sibling_nodes(head):
    pnode = head
    while pnode:
        pcloned = pnode.next
        if pnode.sibling:
            pcloned.sibling = pnode.sibling.next
        pnode = pcloned.next


def reconnect_nodes(head):
    pnode = head
    pcloned_head = None
    pcloned_node = None
    if pnode:
        pcloned_head = pnode.next
        pcloned_node = pnode.next
        pcloned_node.next = pnode.next
        pnode = pnode.next
    while pnode:
        pcloned_node.next = pnode.next
        pcloned_node = pcloned_node.next
        pnode.next = pcloned_node.next
        pnode = pnode.next
    return pcloned_head


def clone(head):
    clone_node(head)
    connect_sibling_nodes(head)
    return reconnect_nodes(head)



