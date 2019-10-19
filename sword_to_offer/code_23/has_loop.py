#!/usr/bin/env python
# -*- coding: utf-8 -*-


class LinkedList(object):
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next


def has_loop(head):
    if not head or not head.next:
        return
    fast_pointer = head
    slow_pointer = head
    while fast_pointer.next:
        fast_pointer = fast_pointer.next
        slow_pointer = slow_pointer.next
        if fast_pointer.next:
            fast_pointer = fast_pointer.next
        if slow_pointer == fast_pointer:
            return True
    return False
