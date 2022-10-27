package bagproblem

/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
*/
func CanPartition(nums []int) bool {
	var sum int
	length := len(nums)
	if length < 2 {
		return false
	}
	for _, v := range nums {
		sum += v
	}
	if sum%2 != 0 {
		return false
	}
	half := sum / 2
	dp := make([]bool, half+1)
	dp[nums[0]] = true
	for i := 1; i < length; i++ {
		for j := half; j >= nums[i]; j-- {
			dp[j] = dp[j] || dp[j-nums[i]]
		}
	}
	return dp[half]
}
