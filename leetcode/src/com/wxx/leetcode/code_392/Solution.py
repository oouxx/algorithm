class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        index = -1
        for i in s:
            index = t[index + 1:].find(i)
            if index == -1:
                print(index + " " + i)
                return False
        return True

if __name__ == "__main__":
    s = Solution()
    a = "leeeeetcode"
    b = "yyylyyyeyyyyeyyyeyyyeyyyeyytyycyyoyydyyeyy"
    res = s.isSubsequence(a, b)
    print(res)