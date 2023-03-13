package recursion
type ListNode struct{
	Val int
	Next *ListNode
}

func MergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode{
	head := &ListNode{}
	tempHead := head

	for (list1.Next != nil && list2.Next != nil) {
		for (list1.Val == list2.Val ) {
			tempHead.Next = list1
			tempHead.Next.Next = list2
			tempHead = tempHead.Next.Next
			list1 = list1.Next
			list2 = list2.Next

		}
		for (list1.Val < list2.Val) {
			tempHead.Next = list1
			list1 = list1.Next
			tempHead = tempHead.Next
		}
		for (list1.Val > list2.Val) {
			tempHead.Next = list2
			list2 = list2.Next
			tempHead = tempHead.Next
		}
	}
	return head
}