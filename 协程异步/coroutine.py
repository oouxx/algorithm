def consumer():
    r = 'init string'
    while True:
        n = yield r
        if not n:
            print("return has been executed")
            return
        print("[Consumer] has comsumed %s..." % n)
        r = "200 OK"


def producer(c):
    res = c.send(None)
    print(res)
    n = 0
    while n < 5:
        n = n + 1
        print("[Producer] producing %s..." % n)
        r = c.send(n)
        print("[Producer] consumer return: %s" % n)
    # c.close()
    try:
        res = c.send(None)
        print(res)
    except Exception as e:
        print(e)
    finally:
        c.close()


c = consumer()
producer(c)
