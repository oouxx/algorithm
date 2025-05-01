package recursion

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func SwapPairs(head *ListNode) *ListNode {
	// if head == nil {
	// 	return head
	// }
	// if head != nil && head.Next == nil {
	// 	return head
	// }
	if head == nil || head.Next == nil {
		return head
	}
	/*
		用 head 表示原始链表的头节点，新的链表的第二个节点，用 newHead 表示新的链表的头节点，原始链表的第二个节点，则原始链表中的其余节点的头节点是 newHead.next。令 head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点。然后令 newHead.next = head，即完成了所有节点的交换。最后返回新的链表的头节点 newHead。

	*/
	newHead := head.Next
	head.Next = SwapPairs(newHead.Next)
	newHead.Next = head
	return newHead
}

func SwapPairsIter(head *ListNode) *ListNode {
	dummyHead := &ListNode{0, head}
	temp := dummyHead
	for temp.Next != nil && temp.Next.Next != nil {
		node1 := temp.Next
		node2 := temp.Next.Next
		temp.Next = node2
		node1.Next = node2.Next
		node2.Next = node1
		temp = node1
	}
	return dummyHead.Next
}
