class Singleton(type):
    _intance = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._intance:
            cls._intance[cls] = super(Singleton, cls).__call__(*args, **kwargs)
        return cls._intance


class MyClass(metaclass=Singleton):
    pass


instance1 = MyClass()
instance2 = MyClass()
print(instance1 is instance1)
print(id(instance1))
print(id(instance2))
