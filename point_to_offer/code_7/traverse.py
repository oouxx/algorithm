from collections import deque


# 先序递归遍历
def preorder_traverse(root_node):
    ret = []

    def traverse(root_node):
        if not root_node:
            return
        ret.append(root_node.value)
        traverse(root_node.left_node)
        traverse(root_node.right_node)

    traverse(root_node)
    return ret


# 后序递归遍历
def postorder_traverse(root_node):
    ret = []

    def traverse(root_node):
        if not root_node:
            return
        traverse(root_node.left_node)
        traverse(root_node.right_node)
        ret.append(root_node.value)

    traverse(root_node)
    return ret


# 中序遍历
def inorder_traverse(root_node):
    ret = []

    def traverse(root_node):
        if not root_node:
            return
        traverse(root_node.left_node)
        ret.append(root_node.value)
        traverse(root_node.right_node)

    traverse(root_node)
    return ret


def bfs(root_node):
    ret = []
    queue = deque([root_node])
    while queue:
        root_node = queue.popleft()
        if root_node:
            ret.append(root_node.value)
            queue.append(root_node.left_node)
            queue.append(root_node.right_node)
    return ret
