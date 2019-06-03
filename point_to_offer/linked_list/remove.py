from point_to_offer.linked_list.base import LinkNode
from point_to_offer.linked_list.create import create
from point_to_offer.linked_list.output import output


def remove(head, value):
    while head.next:
        if head.next.value == value:
            head.next = head.next.next
        head = head.next


if __name__ == '__main__':
    head = LinkNode()
    create(head)
    remove(head, 5)
    output(head)
