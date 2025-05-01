package test

import (
	"fmt"
	"testing"

	"wxx.com/go-leetcode/dp"
)

func TestUniquePathsWithObstacles(t *testing.T) {
	res := dp.UniquePathsWithObstacles([][]int{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})
	fmt.Println(res)

}
