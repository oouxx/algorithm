from functools import wraps


def singleton(cls):
    instances = {}

    @wraps(cls)
    def wrapper(*args, **kwargs):
        if cls not in instances:
            instances[cls] = cls(*args, **kwargs)
        return instances[cls]

    return wrapper


@singleton
class MyClass:
    pass


instance1 = MyClass()
instance2 = MyClass()
print(instance1 is instance2)
print(id(instance1))
print(id(instance2))
