package recursion

type ListNode struct {
	Val  int
	Next *ListNode
}

// 合并两个有序链表
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

// 使用递归
func MergeTwoLists2(list1 *ListNode, list2 *ListNode) *ListNode {
	if list1 == nil {
		return list2
	} else if list2 == nil {
		return list1
	} else if list1.Val < list2.Val {
		list1.Next = MergeTwoLists2(list1.Next, list2)
		return list1
	} else {
		list2.Next = MergeTwoLists2(list1, list2.Next)
		return list2
	}

}
