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
func TestRemoveDuplicates(t *testing.T) {
	l := array.RemoveDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 4})
	fmt.Println(l)
}
func TestRemoveElement(t *testing.T) {
	l := array.RemoveElement([]int{2, 3, 3, 2}, 3)
	fmt.Println(l)
}
