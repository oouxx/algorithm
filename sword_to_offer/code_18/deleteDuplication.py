#!/usr/bin/env python
# -*- coding: utf-8 -*-

class LinkedList(object):
    def __init__(self, val, next = None):
        self.val = val
        self.next = next


def delete_duplication(head):
    

if __name__ == "__main__":
    head = LinkedList(1)
    head.next = LinkedList(1)
    head.next.next = LinkedList(1)
    delete_duplication(head)
    print(head.val)
    print(head.next)
