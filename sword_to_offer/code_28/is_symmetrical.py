#!/usr/bin/env python
# -*- coding: utf-8 -*-


def is_symmetrical(root):
    return is_symmetrical(root, root)


def is_symmetrical_core(root1, root2):
    if not root1 and not root2:
        return True
    if not root1 or not root2:
        return False
    if root1.val != root2.val:
        return False
    return is_symmetrical_core(root1.left, root2.right) and is_symmetrical_core(root1.right, root2.left)


