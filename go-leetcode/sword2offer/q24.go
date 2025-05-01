package gosword2offer

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func ReverseList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    newHead := ReverseList(head.Next)
    head.Next.Next = head
	// head.Next 为nil否则会产生环
    head.Next = nil
    return newHead
}
