package test

import (
	"testing"

	"wxx.com/go-leetcode/recursion"
)

func TestMergeTwoLists(t *testing.T) {
	list1 := NewListNodeFromArray([]int{1, 2 ,4})
	list2 := NewListNodeFromArray([]int{1, 3 ,4})

	recursion.MergeTwoLists(list1, list2)	
}
func NewListNodeFromArray(arr []int) *recursion.ListNode{
	head := &recursion.ListNode{}
	tempHead := head 
	for _, v := range arr{
		tempHead.Next = &recursion.ListNode{
			Val: v,
			Next: nil,
		}
		tempHead = tempHead.Next
	}
}