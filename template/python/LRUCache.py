from collections import OrderedDict


class LRUCache(object):
    def __init__(self, capacity=128):
        self.od = OrderedDict()  # 循环双端链表
        self.capacity = capacity

    def get(self, key):
        if key in self.od:
            val = self.od[key]
            self.od.move_to_end(key)  # 把最近使用的移到表头
            return val
        else:
            return -1

    def put(self, key, value):
        if key in self.od:
            del self.od[key]
            self.od[key] = value  # 删除重新插入到尾部，相当于调整了位置到尾部
        else:
            self.od[key] = value
        # 删除最早的元素
        if len(self.od) > self.capacity:
            self.od.popitem(last=False)

    def printOD(self):
        print(self.od)
