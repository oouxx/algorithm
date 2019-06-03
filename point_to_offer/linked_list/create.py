from point_to_offer.linked_list.base import LinkNode
from point_to_offer.linked_list.add_to_tail import add_to_tail
from point_to_offer.linked_list.output import output, reverse_output


def create(head):
    for i in range(10):
        add_to_tail(head, i)


if __name__ == '__main__':
    head = LinkNode()
    create(head)
    output(head)
    reverse_output(head)
