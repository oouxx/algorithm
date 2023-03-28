package array

// 0 1 0 3 12
// 1 0 0 3 12
// 1 3 0 0 12
// 1 3 12 0 0
func MoveZeroes(nums []int) {
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			for j := i; j < len(nums); j++ {
				if nums[j] != 0 {
					// 找到第一个非零数字进行交换
					// swap(nums, i, j)
					nums[i], nums[j] = nums[j], nums[i]
					break
				}
			}
		}
	}
}

// func swap(nums []int, i, j int) {
// 	temp := nums[i]
// 	nums[i] = nums[j]
// 	nums[j] = temp
// }
