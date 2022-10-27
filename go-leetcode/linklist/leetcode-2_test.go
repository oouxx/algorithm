package linklist_test

import (
	"fmt"
	"testing"

	"wxx.com/go-leetcode/linklist"
)

func TestAddTwoNumbers(t *testing.T) {
	l1 := linklist.Array2ListNode([]int{9, 9, 9, 9, 9, 9, 9})
	l2 := linklist.Array2ListNode([]int{9, 9, 9, 9})
	// l1 := recursion.Array2ListNode([]int{2, 4, 3})
	// l2 := recursion.Array2ListNode([]int{5, 6, 4})
	res := linklist.AddTwoNumbers(l1, l2)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
