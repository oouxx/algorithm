def output(head):
    while head.next:
        print(head.next.value)
        head = head.next


def reverse_output(head):
    stack = []
    while head.next:
        stack.append(head.next.value)
        head = head.next
    while stack:
        print(stack.pop())
