package gosword2offer

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func ReverseList(head *ListNode) *ListNode {
	if head == nil {
		return &ListNode{}
	}
	ln := ReverseList(head.Next)
	ln.Next = head
	return ln
}
