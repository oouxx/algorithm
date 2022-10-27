package array

import (
	"sort"
)

/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
*/
/*
题解：排序+双指针
排序可以过滤重复三元组

1. 第二重循环，第三重循环为双指针
2. 每一重循环相邻的元素不能相同
*/
func ThreeSum(nums []int) [][]int {
	var res [][]int
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		if i > 0 && nums[i-1] == nums[i] {
			continue
		}
		k := len(nums) - 1
		for j := i + 1; j < len(nums); j++ {
			if j > i+1 && nums[j-1] == nums[j] {
				continue
			}
			for j < k && nums[j]+nums[k] > 0-nums[i] {
				k--
			}
			if k == j {
				break
			}

			if nums[i]+nums[j]+nums[k] == 0 {
				res = append(res, []int{nums[i], nums[j], nums[k]})
			}
		}
	}
	return res
}
