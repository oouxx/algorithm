package array

func SearchInsert(nums []int, target int) int {
	left := 0
	right := len(nums) - 1
	ans := len(nums)
	for left <= right {
		mid := (right-left)>>1 + left
		if target <= nums[mid] {
			ans = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return ans
}
