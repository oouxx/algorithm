package greedy

/*
设想一下，对于数组中的任意一个位置 yy，我们如何判断它是否可以到达？根据题目的描述，只要存在一个位置 xx，它本身可以到达，并且它跳跃的最大长度为 x + \textit{nums}[x]x+nums[x]，这个值大于等于 yy，即 x + \textit{nums}[x] \geq yx+nums[x]≥y，那么位置 yy 也可以到达
*/
func canJump(nums []int) bool {
	maxReachIndex := 0
	n := len(nums)
	for i := 0; i < n; i++ {
		if i <= maxReachIndex { // 因为nums[i] 有等于零的情况，所以i可能比maxReachIndex增大的快，所以加上这个限制
			if i+nums[i] > maxReachIndex {
				maxReachIndex = i + nums[i]
			}
			if maxReachIndex >= n-1 {
				return true
			}
		}
	}
	return false
}
