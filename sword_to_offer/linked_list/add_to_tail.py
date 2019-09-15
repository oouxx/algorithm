from point_to_offer.linked_list.base import LinkNode


def add_to_tail(head, value):
    new_node = LinkNode(value)
    if head is None:
        head = new_node
    node = head
    while node.next:
        node = node.next
    node.next = new_node
