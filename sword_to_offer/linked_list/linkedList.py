class LinkNode(object):
    def __init__(self, value, next=None):
        self.value = value
        self.next = None

    def __call__(self, *args, **kwargs):
        print(self.value)

    def add_to_tail(self, head, value):
        new_node = LinkNode(value)
        if head is None:
            head = new_node
        node = head
        while node.next:
            node = node.next
        node.next = new_node

    def create(self, head):
        for i in range(10):
            self.add_to_tail(head, i)

    def output(self, head):
        while head.next:
            print(head.next.value)
            head = head.next

    def reverse_output(self, head):
        stack = []
        while head.next:
            stack.append(head.next.value)
            head = head.next
        while stack:
            print(stack.pop())

    def remove(self, head, value):
        while head.next:
            if head.next.value == value:
                head.next = head.next.next
            head = head.next
