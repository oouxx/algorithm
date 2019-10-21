#!/usr/bin/env python
# -*- coding: utf-8 -*-


class LinkedList(object):
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next


def meeting_node(head):
    if not head or not head.next:
        return None
    fast_pointer = head
    slow_pointer = head
    while fast_pointer.next:
        fast_pointer = fast_pointer.next
        slow_pointer = slow_pointer.next
        if fast_pointer.next:
            fast_pointer = fast_pointer.next
        if slow_pointer == fast_pointer:
            return fast_pointer
    return None


def entry_node_of_loop(head):
    mnode = meeting_node(head)
    if not mnode:
        return
    pnode = mnode
    nodes_loop = 1
    while pnode.next != mnode:
        pnode = pnode.next
        nodes_loop += 1
    hnode = head
    while hnode != mnode:
        hnode = hnode.next
        mnode = mnode.next
    return mnode
