def reverse_list(head):
    if not head:
        return
    reverse_head = None
    cur_node = head
    pre_node = None
    while cur_node:
        next_node = cur_node.next
        if next_node is None:
            reverse_head = cur_node
        cur_node.next = pre_node
        pre_node = cur_node
        cur_node = next_node
    return reverse_head
