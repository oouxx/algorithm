class LinkNode(object):
    def __init__(self, val=None):
        self.value = val
        self.next = None

    def __call__(self, *args, **kwargs):
        print(self.value)
