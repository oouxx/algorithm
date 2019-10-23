#!/usr/bin/env python
# -*- coding: utf-8 -*-


class BinaryTree(object):
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.rght = right


def mirror_recursively(root):
    if not root:
        return
    swap(root)
    mirror_recursively(root.left)
    mirror_recursively(root.right)


def swap(root):
    tmp = root.left
    root.left = root.right
    root.right = tmp
