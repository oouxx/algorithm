package test

import (
	"fmt"
	"testing"

	gosword2offer "wxx.com/go-leetcode/sword2offer"
)

func TestReverseList(t *testing.T) {
	head := &gosword2offer.ListNode{}
	head.Val = 1
	head.Next = &gosword2offer.ListNode{
		Val:  2,
		Next: nil,
	}
	ln := gosword2offer.ReverseList(head)
	for ln.Next != nil {
		fmt.Println(ln.Val)
	}
}
