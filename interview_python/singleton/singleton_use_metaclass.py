class Singleton(type):
    _instance = None

    def __call__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(Singleton, cls).__call__(*args, **kwargs)
        return cls._instance


class MyClass(metaclass=Singleton):
    pass


# Python2
# class MyClass(object):
#     __metaclass__ = Singleton


one = MyClass()
two = MyClass()
print(one == two)
print(one is two)
