#!/usr/bin/env python
# -*- coding: utf-8 -*-


class LinkedList(object):
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next


def find_kth_to_tail(head, k):
    if not head or k == 0:
        return
    first_pointer = head
    second_pointer = head
    for i in range(k - 1):
        if first_pointer.next:
            first_pointer = first_pointer.next
        else:
            return

    while first_pointer.next:
        first_pointer = first_pointer.next
        second_pointer = second_pointer.next

    return second_pointer


def createLinkedList():
    head = LinkedList()
    hnode = head
    for i in range(1, 10):
        hnode.next = LinkedList(i)
        hnode = hnode.next
    return head


if __name__ == "__main__":
    result = find_kth_to_tail(createLinkedList(), 5)
    print(result.val)
