from collections import Iterable
from collections import Iterator


class Foo:
    def __iter__(self):
        pass

    def __next__(self):
        pass


print(isinstance(Foo(), Iterable))
print(isinstance(Foo(), Iterator))
