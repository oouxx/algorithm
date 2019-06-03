class LinkedList(object):
    def __init__(self, val=None):
        self.value = val
        self.next = None


class PrintLinkedList(object):
    """
    从尾到头打印单链表
    思路一：递归
    思路二：栈
    思路三:改变原链表结构
    """

    def __init__(self, head=None):
        self.linkedlist = head

    # 递归打印
    def recursive_printing(self, head=None):
        if not head:
            head = self.linkedlist
        if head:
            if head.next:
                self.recursive_printing(head.next)
        print(head.value, end=" ")

    # 基于栈逆序打印链表
    def stack_printing(self):
        if self.linkedlist is None:
            return
        head = self.linkedlist
        my_stack = []
        while head:
            my_stack.append(head.value)
            head = head.next
        while my_stack:
            print(my_stack.pop(), end=" ")

    # 改变链表结构打印(不推荐)
    def printing(self):
        if not self.linkedlist:
            return
        head = self.linkedlist
        pre = None
        while head:
            next = head.next
            head.next = pre
            pre = head
            head = next
        while pre:
            print(pre.value, end=" ")
            pre = pre.next


if __name__ == '__main':
    # 以上使用类组织代码
    # a simple test demo
    head = LinkedList(0)
    node = head
    for i in range(1, 5):
        node.next = LinkedList(i)
        node = node.next

    print_linked_list = PrintLinkedList(head)
    print_linked_list.stack_printing()
    print('\n')
    print_linked_list.recursive_printing()
    print('\n')
    print_linked_list.printing()
