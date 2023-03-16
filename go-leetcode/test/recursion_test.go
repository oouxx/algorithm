package test

import (
	"fmt"
	"testing"

	"wxx.com/go-leetcode/recursion"
)

func TestMergeTwoLists(t *testing.T) {
	list1 := NewListNodeFromArray([]int{1, 2, 4})
	list2 := NewListNodeFromArray([]int{1, 3, 4})
	// printListNode(list1)
	// printListNode(list2)
	head := recursion.MergeTwoLists(list1, list2)
	printListNode(head)
}
func TestSwarpPairs(t *testing.T) {
	list1 := NewListNodeFromArray([]int{1, 2, 3, 4})
	head := recursion.SwapPairs(list1)
	printListNode(head)
}
func NewListNodeFromArray(arr []int) *recursion.ListNode {
	head := &recursion.ListNode{}
	tempHead := head
	for _, v := range arr {
		tempHead.Next = &recursion.ListNode{
			Val:  v,
			Next: nil,
		}
		tempHead = tempHead.Next
	}
	return head.Next
}
func printListNode(ln *recursion.ListNode) {
	for ln != nil {
		fmt.Println(ln.Val)
		ln = ln.Next
	}
}
