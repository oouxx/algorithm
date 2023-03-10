package gosword2offer

// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

// 逆序要想到的几种数据结构 栈，递归
// 1. 递归 2. 栈 3. 双链表
func reversePrint(head *ListNode) (res []int) {
	if head == nil {
		return res
	}
	res = reversePrint(head.Next)
	res = append(res, head.Val)
	return res
}
