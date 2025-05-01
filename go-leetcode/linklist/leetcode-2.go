package linklist

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func AddTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	res := &ListNode{}
	head := res
	// var addTwoNumList func(*ListNode, *ListNode, int, *ListNode) (*ListNode, int)
	addTwoNumList := func(ln1 *ListNode, ln2 *ListNode, p int, ans *ListNode) (*ListNode, int) {
		temp := &ListNode{}
		sum := ln1.Val + ln2.Val + p
		temp.Val = sum % 10
		ans.Next = temp
		p = sum / 10
		return ans, p
	}
	// TODO 去掉i,j
	i := 0
	j := 0
	carry := 0
	for l1 != nil || l2 != nil {
		if l1 != nil {
			i++
		}
		if l2 != nil {
			j++
		}
		if i == j {
			res, carry = addTwoNumList(l1, l2, carry, res)
			l1 = l1.Next
			l2 = l2.Next
		} else if i < j {
			res, carry = addTwoNumList(&ListNode{}, l2, carry, res)
			l1 = nil
			l2 = l2.Next
		} else if i > j {
			res, carry = addTwoNumList(l1, &ListNode{}, carry, res)
			l1 = l1.Next
			l2 = nil
		}
		res = res.Next
	}
	if carry != 0 {
		res.Next = &ListNode{
			Val: carry,
		}
	}
	return head.Next
}
