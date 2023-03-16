package recursion

type ListNode struct {
	Val  int
	Next *ListNode
}

func MergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	head := &ListNode{}
	tempHead := head

	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			tempHead.Next = list1
			list1 = list1.Next
		} else {
			tempHead.Next = list2
			list2 = list2.Next
		}
		tempHead = tempHead.Next
	}
	if list1 == nil {
		tempHead.Next = list2
	} else {
		tempHead.Next = list1
	}
	return head.Next
}
