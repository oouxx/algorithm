class TwoStackQueue:
    def __init__(self):
        self.stack_one = []
        self.stack_two = []

    def push(self, value):
        self.stack_one.append(value)

    def pop(self):
        self.stack_one.reverse()
        self.stack_two, self.stack_one = self.stack_one, self.stack_two
        result = self.stack_two.pop()
        self.stack_two.reverse()
        self.stack_two, self.stack_one = self.stack_one, self.stack_two
        return result


tsq = TwoStackQueue()
tsq.push(4)
tsq.push(1)
tsq.push(2)
tsq.push(3)

print(tsq.pop())
print(tsq.pop())
print(tsq.pop())
