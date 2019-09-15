# 保存哈希表法
class Solution(object):
    def twoSum(self, nums, target):
        nums_dict = dict()
        for index in range(len(nums)):
            temp = target - nums[index]
            if temp in nums_dict and nums_dict[temp] != index:
                return [index, nums_dict[temp]]
            nums_dict[nums[index]] = index
