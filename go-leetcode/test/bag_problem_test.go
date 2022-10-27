package test

import (
	"fmt"
	"testing"

	"wxx.com/go-leetcode/bagproblem"
)

func TestCanPartition(t *testing.T) {
	res := bagproblem.CanPartition([]int{1, 2, 3, 6})
	fmt.Println(res)
}
