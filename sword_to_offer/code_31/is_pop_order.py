#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""未完成
"""


class Stack(object):
    def __init__(self, capcity=100):
        self.capcity = capcity
        self.cus_stack = []
        self.help_stack = []
        self.min_num = 0

    def push(self, num):
        if len(self.cus_stack) < self.capcity:
            self.cus_stack.append(num)
            if len(self.help_stack) == 0:
                self.help_stack.append(num)
                self.min_num = num
            else:
                if num < self._top():
                    self.help_stack.append(num)
                    self.min_num = num
                else:
                    self.help_stack.append(self._top())

    def pop(self):
        if self.capcity > 0:
            self.cus_stack.pop()
            self.help_stack.pop()

    def _top(self):
        return self.help_stack[-1]

    def top(self):
        return self.cus_stack[-1]

    def is_pop_order(self, push_order, pop_order):
        if not push_order or not pop_order:
            return
        result = True
        push_order_index = 0
        self.push(push_order[push_order_index])
        push_order_index += 1
        for i in range(len(pop_order)):
            if self.top() != pop_order[i]:
                #j = push_order_index + 1
                #while j < len(push_order) and self.top() != pop_order[i]:
                #    self.push(push_order[j])
                #if j == len(push_order):
                #    result = False
                #    return result
                #if self.top() == pop_order[i]:
                #    push_order_index = j
                #    self.pop()
                for j in range(push_order_index + 1, len(push_order)):
                    self.push(push_order[j])
                    if self.top() == pop_order[i]:
                        push_order_index = j - 1
                        self.pop()
                        break
                    if j == len(push_order) - 1:
                        result = False
                        return result
            else:
                self.pop()
        return result


if __name__ == "__main__":
    s = Stack()
    res = s.is_pop_order([1, 2, 3, 4, 5], [4, 5, 3, 2, 1])
    print(res)
