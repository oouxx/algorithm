class BinaryTree:
    def __init__(self, value, left_node=None, right_node=None, parent_node=None):
        self.value = value
        self.left_node = left_node
        self.right_node = right_node
        self.parent_node = parent_node

    # 获取中序遍历序列中的下一个节点
    def get_next(self):
        # 如果一个节点有右子树，那么它的下一个节点就是它右子树的最左节点
        if self.right_node:
            p = self.right_node
            while p.left_node:
                p = p.left_node
            return p.value
        # 如果当前节点的父节点的左节点是自己，那么我的下一个节点就是父节点
        elif self.parent_node.left_node == self:
            return self.parent_node.value
        # 初次之外，沿着父链向上找，找到当前节点是父节点左节点的情况，返回父节点
        else:
            current = self
            while current.parent_node:
                current = current.parent_node
                if self.parent_node.left_node == current:
                    break
            return current.parent_node.value


# to test it you can construct more complex BinaryTree
root = BinaryTree(0)
root.left_node = BinaryTree(1)
root.left_node.parent_node = root
root.right_node = BinaryTree(2)
root.right_node.parent_node = root


root_next = root.left_node.get_next()
print(root_next)
