#!/usr/bin/env python
# -*- coding: utf-8 -*-


from collections import deque


class BinaryTree(object):
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def print_from_top_to_bottom(root):
    if not root:
        return
    queue = deque()
    queue.append(root)
    while len(queue) > 0:
        node = queue.popleft()
        if node:
            print(node.val)
            queue.append(node.left)
            queue.append(node.right)


if __name__ == "__main__":
    def create_binary_tree():
        root = BinaryTree(0)
        root.left = BinaryTree(1)
        root.right = BinaryTree(2)
        root.left.left = BinaryTree(3)
        root.left.right = BinaryTree(4)
#        root.right.left = BinaryTree(5)
        root.right.right = BinaryTree(6)
        return root
    print_from_top_to_bottom(create_binary_tree())


