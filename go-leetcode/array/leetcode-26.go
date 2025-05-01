package array

func RemoveDuplicates(nums []int) int {
	i := 1
	for i < len(nums) {
		if nums[i] == nums[i-1] {
			// 删除index 为i-1 元素
			nums = append(nums[:i-1], nums[i:]...)
		} else {
			i++
		}
	}
	return len(nums)
}
