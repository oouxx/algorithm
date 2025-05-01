package greedy

/*
给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。
*/

/*
在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。

没必要
*/
func jump(nums []int) int {
	length := len(nums)
	end := 0
	maxReachIndex := 0
	steps := 0
	for i := 0; i < length-1; i++ {
		if maxReachIndex < i+nums[i] {
			maxReachIndex = i + nums[i]
		}
		if i == end {
			end = maxReachIndex
			steps++
		}
	}
	return steps
}
