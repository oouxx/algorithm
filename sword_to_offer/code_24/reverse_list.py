def reverse_list(head):
    if not head:
        return
    pre_node = None
    cur_node = head
    while cur_node:
        next_node = cur_node.next
        cur_node.next = pre_node
        pre_node = cur_node
        cur_node - next_node
    return pre_node

