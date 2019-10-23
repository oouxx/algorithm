def merge(head_one, head_two):
    if not head_one or not head_two:
        return
    cur_node_one = head_one.next
    pre_node = head_one
    cur_node_two = head_two.next
    while cur_node_one.next and cur_node_two.next:
        while cur_node_one.next and cur_node_two.next and cur_node_one.val < cur_node_two.val:
            cur_node_one = cur_node_one.next
        next_node = cur_node_two.next
        pre_node.next = cur_node_two
        cur_node_two.next = cur_node_one
        cur_node_two = next_node

    if cur_node_one.next is None:
        cur_node_one.next = cur_node_two.next
    return head_one
