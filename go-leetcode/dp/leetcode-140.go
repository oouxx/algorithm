package dp

import "strings"

/*
可以使用动态规划来解决这个问题，以下是详细步骤：

将字典中的所有单词存储到一个 hash 集合中，以方便快速判断一个字符串是否在字典中。
创建一个数组 dp，其中 dp[i] 表示以位置 i 结尾的子串是否能拆分成字典中的单词。数组长度为 n+1，多设置一位，便于计算最终结果。
初始化 dp[0] 为 true，表示空串可以拆分成字典中的单词。
遍历字符串 s，对于每个位置 i，从位置 0 到 i-1 遍历位置 j。如果 dp[j] 为 true 且子串 s[j:i] 在字典中出现，则将 dp[i] 设为 true。
遍历结束后，若 dp[n] 为 true，则说明原字符串可以被拆分成字典中的单词。可以根据 dp 数组还原出所有可能的句子，具体方法是使用 dfs 或回溯算法，从 dp 数组末尾开始遍历，每找到一个可行解就将其加入结果集合中。
以下是 Golang 的实现代码：
*/
func wordBreak2(s string, wordDict []string) []string {
	n := len(s)
	dp := make([]bool, n+1)
	dp[0] = true // 空串可以拆分成字典中的单词

	wordSet := make(map[string]bool)
	for _, word := range wordDict {
		wordSet[word] = true
	}

	// 计算dp数组
	for i := 1; i <= n; i++ {
		for j := 0; j < i; j++ {
			if dp[j] && wordSet[s[j:i]] {
				dp[i] = true
				break
			}
		}
	}

	// 回溯还原出所有可能的句子
	var result []string
	if dp[n] {
		path := make([]string, 0) // 用于存储当前路径
		backtrack(dp, s, n, wordSet, &path, &result)
	}

	return result
}

// 回溯还原出所有可能的句子
func backtrack(dp []bool, s string, end int, wordSet map[string]bool, path *[]string, result *[]string) {
	// base case: 从后往前遍历，遇到 dp[i]=true 的点即找到了一种可行解
	if end == 0 {
		*result = append(*result, strings.Join(*path, " "))
		return
	}

	// 枚举最后一个单词的起始位置 i
	for i := end - 1; i >= 0; i-- {
		word := s[i:end]
		if dp[i] && wordSet[word] {
			*path = append([]string{word}, *path...)   // 添加到路径开头
			backtrack(dp, s, i, wordSet, path, result) // 递归
			*path = (*path)[1:]                        // 回溯，恢复路径状态
		}
	}
}

// 时间复杂度为 $O(n^2+m)$，其中 $n$ 表示字符串 s 的长度，$m$ 表示字典中单词的数量。空间复杂度为 $O(n+m)$，主要用于存储 dp 数组和 hash 集合。
