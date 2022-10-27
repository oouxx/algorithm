package test

import (
	"fmt"
	"testing"

	"wxx.com/go-leetcode/array"
)

func TestThreeSums(t *testing.T) {
	res := array.ThreeSum([]int{-1, 0, 1, 2, -1, -4})
	fmt.Println(res)
}
