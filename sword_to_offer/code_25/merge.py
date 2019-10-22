def merge(head_one, head_two):
    if not head_one or not head_two:
        return
    cur_one = head_one.next
    cur_two = head_two.next
    while cur_one and cur_two:
        while cur_one and cur_two and cur_one.val < cur_two.val:
            cur_one = cur_one.next
