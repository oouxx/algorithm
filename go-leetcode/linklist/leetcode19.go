package linklist

// 使用双指针，右指针先移动n个位置，然后两个指针同步移动，右指针移到头左指针的位置就是要删除的节点
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	dummy := &ListNode{0, head}
	pointer1 := head
	pointer2 := dummy
	for i := 0; i < n; i++ {
		pointer1 = pointer1.Next
	}
	for pointer1 != nil {
		pointer1 = pointer1.Next
		pointer2 = pointer2.Next
	}
	pointer2.Next = pointer2.Next.Next
	return dummy.Next
}
