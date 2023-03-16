package test

import (
	"fmt"
	"testing"

	"wxx.com/go-leetcode/greedy"
)

func TestLongestPalindrome(t *testing.T) {
	length := greedy.LongestPalindrome("aaaaaccc")
	fmt.Println(length)
}
