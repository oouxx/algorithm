class Solution(object):
    def cut(origin_string):
        result = []
        num = 0
        for x in range(len(origin_string)):
            for i in range(len(origin_string) - x):
                result.append(origin_string[i:i+x+1])
                num += 1
        return result


if __name__ == "__main__":
    pass
