# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    # dfs问题
    # 返回二维列表，内部每个列表表示找到的路径
    def FindPath(self, root, expectNumber):
        res = []
        if not root:
            return res
        self.target = expectNumber
        self.dfs(root, res, [root.val])
        return res

    def dfs(self, root, res, path):
        # 该节点时叶子节点且路径和为目标值,就加入到结果集中
        if not root.left and not root.right and sum(path) == self.target:
            res.append(path)
        if root.left:
            self.dfs(root.left, res, path + [root.left.val])
        if root.right:
            self.dfs(root.right, res, path + [root.right.val])
