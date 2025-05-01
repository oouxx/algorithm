package slidingwindow

// 滑动窗口
/*
滑动窗口算法的思路是这样：

我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，把索引闭区间 [left, right] 称为一个「窗口」。

我们先不断地增加 right 指针扩大窗口 [left, right]，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。

此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。

重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
*/
func lengthOfLongestSubstring1(s string) int {
	length := len(s)
	subSeques := map[byte]int{}
	// [left,right)
	right := -1
	maxLength := 0
	// for right < length {
	// 	if _, ok := subSeques[s[right]]; ok {
	// 		left = subSeques[s[right]]
	// 	} else {
	// 		subSeques[s[right]] = right
	// 	}
	// 	if right-left > maxLength {
	// 		maxLength = right - left
	// 	}
	// 	right++
	// }

	for i := 0; i < length; i++ {
		if i != 0 {
			delete(subSeques, s[i-1])
		}
		for right+1 < length && subSeques[s[right+1]] == 0 {
			subSeques[s[right+1]]++
			right++
		}
		if right-i+1 > maxLength {
			maxLength = right - i + 1
		}
	}
	return maxLength
}

func lengthOfLongestSubstring(s string) int {
	// 哈希集合，记录每个字符是否出现过
	m := map[byte]int{}
	n := len(s)
	// 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
	rk, ans := -1, 0
	for i := 0; i < n; i++ {
		if i != 0 {
			// 左指针向右移动一格，移除一个字符
			delete(m, s[i-1])
		}
		// 不重复，退出循环
		for rk+1 < n && m[s[rk+1]] == 0 {
			// 不断地移动右指针
			m[s[rk+1]]++
			rk++
		}
		// 第 i 到 rk 个字符是一个极长的无重复字符子串
		ans = max(ans, rk-i+1)
	}
	return ans
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}
