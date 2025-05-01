package dp

/*
可以使用动态规划来解决这个问题，以下是详细步骤：

创建一个布尔型的一维数组 dp，其中 dp[i] 表示字符串 s 的前 i 个字符是否可被空格拆分成若干个字典中出现的单词。
初始化 dp 数组，dp[0] 置为 true，表示空字符串可以被拆分成若干个字典中出现的单词。注意，这里的 dp[0] 并不是代表 s 的前 0 个字符，而是代表 s 的前 1 个字符（空字符串）。
遍历字符串 s 的每一个字符，用 j 表示当前遍历到的字符的下标，再用 i(0 <= i < j) 表示当前区间的起始位置。如果 dp[i] 为 true，且单词表中存在 s[i,j)，则 dp[j] 置为 true。其中 s[i,j) 表示子串 s[i:j]，不包括第 j 个字符。
最终返回 dp 数组最后一个元素 dp[n] 的值，其中 n 表示字符串 s 的长度。
以下是 Golang 的实现代码：
*/
func wordBreak(s string, wordDict []string) bool {
	n := len(s)
	dp := make([]bool, n+1)
	dp[0] = true

	for j := 1; j <= n; j++ {
		for i := 0; i < j; i++ {
			if dp[i] && wordInDict(s[i:j], wordDict) {
				dp[j] = true
				break
			}
		}
	}

	return dp[n]
}

// 判断单词是否在字典中
func wordInDict(word string, wordDict []string) bool {
	for _, w := range wordDict {
		if w == word {
			return true
		}
	}
	return false
}

// 时间复杂度为 $O(n^2)$，其中 $n$ 是字符串 s 的长度。
