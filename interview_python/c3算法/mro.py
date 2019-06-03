def c3_lineration(kls):
    if len(kls.__bases__) == 1:
        return [kls, kls.__base__]
    else:
        l = [c3_lineration(base) for base in kls.__bases__]
        l.append([base for base in kls.__bases__])
        return [kls] + merge(l)


def merge(args):
    if args:
        for mro_list in args:
            for class_type in mro_list:
                for comp_list in args:
                    if class_type in comp_list[1:]:
                        break
                else:
                    next_merge_list = []
                    for arg in args:
                        if class_type in arg:
                            arg.remove(class_type)
                            if arg:
                                next_merge_list.append(arg)
                        else:
                            next_merge_list.append(arg)
                    return [class_type] + merge(next_merge_list)
        else:
            raise Exception
    else:
        return []


class A(object):
    pass


class B(object):
    pass


class C(object):
    pass


class E(A, B):
    pass


class F(B, C):
    pass


class H(A, C):
    pass


class G(E, F, H):
    pass


print(c3_lineration(G))
