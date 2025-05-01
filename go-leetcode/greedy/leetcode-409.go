package greedy

func LongestPalindrome(s string) int {
	count := [128]int{}
	for _, v := range s {
		count[v]++
	}
	ans := 0
	for _, v := range count {
		ans += v / 2 * 2
		if v%2 == 1 && ans%2 == 0 {
			ans++
		}
	}
	return ans
}
