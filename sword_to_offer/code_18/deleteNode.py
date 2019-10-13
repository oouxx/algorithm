#!/usr/bin/env python
# -*- coding: utf-8 -*-

#class LinkedList(object):
#    def __init__(self, val, next = None):
#        self.val = val
#        self.next = next
def delete_node(head, node):
    """delete linkedList node with O(1)
    """
    if head is None or node is None:
        return
    if node.next is not None:
        node_next = node.next
        node.val = node.next.val
        node.next = node.next.next
        del node_next
    # node is the first node and last node
    elif head == node:
        del node
        node = None
        head = None
    else:
        pnode = head
        while pnode.next != node:
            pnode = pnode.next
        pnode.next = None
        del node
        node = None


