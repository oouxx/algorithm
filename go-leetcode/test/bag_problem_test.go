package test

import (
	"fmt"
	"testing"

	bagproblem "wxx.com/go-leetcode/bag_problem"
)

func TestCanPartition(t *testing.T) {
	res := bagproblem.CanPartition([]int{1, 2, 3, 6})
	fmt.Println(res)
}
