"""
    :author wxx
    :description 根据前序遍历和中序遍历重构二叉树
"""
from point_to_offer.code_7.base import BinaryTree
from point_to_offer.code_7.traverse import inorder_traverse, preorder_traverse, postorder_traverse, bfs


def construct(preorder, inorder):
    if preorder is None or inorder is None:
        return
    return construct_core(preorder, inorder)


def construct_core(preorder, inorder):
    if not preorder or not inorder:
        return None
    # 前序遍历的第一个节点是根节点
    root = preorder[0]
    root_node = BinaryTree(root)
    root_index = inorder.index(root)

    # inorder
    in_left_tree = inorder[:root_index]
    in_right_tree = inorder[root_index + 1:]

    # preorder
    pre_left_tree = preorder[1:1 + len(in_left_tree)]
    pre_right_tree = preorder[-len(in_right_tree):]

    left_node = construct_core(pre_left_tree, in_left_tree)
    right_node = construct_core(pre_right_tree, in_right_tree)
    root_node.left_node = left_node
    root_node.right_node = right_node
    return root_node


if __name__ == '__main__':
    preorder = [1, 2, 4, 7, 3, 5, 6, 8]
    inorder = [4, 7, 2, 1, 5, 3, 8, 6]
    root_node = construct(preorder, inorder)
    bfs_list = bfs(root_node)
    preorder_list = preorder_traverse(root_node)
    inorder_list = inorder_traverse(root_node)
    postorder_list = postorder_traverse(root_node)
    print(bfs_list)
    print(preorder_list)
    print(inorder_list)
    print(postorder_list)
