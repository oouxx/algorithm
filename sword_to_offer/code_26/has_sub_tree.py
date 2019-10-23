#!/usr/bin/env python
# -*- coding: utf-8 -*-


class BinaryTree(object):
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right


def has_sub_tree(root1, root2):
    result = False
    if root1 and root2:
        if root1.val == root2.val:
            result = does_tree1_has_tree2(root1, root2)
        if not result:
            result = does_tree1_has_tree2(root1.left, root2)
        if not result:
            result = does_tree1_has_tree2(root1.right, root2)
    reutrn result


def does_tree1_has_tree2(root1, root2):
    if not root2:
        return False

    if not root1:
        return False

    if root1.val != root2.val:
        return False
    return does_tree1_has_tree2(root1.left, root2.left) and does_tree1_has_tree2(root1.right, root2.right)
