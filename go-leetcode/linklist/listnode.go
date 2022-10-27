package linklist

type ListNode struct {
	Val  int
	Next *ListNode
}

func Array2ListNode(nums []int) *ListNode {
	res := &ListNode{}
	head := res
	for _, v := range nums {
		res.Next = &ListNode{
			Val: v,
		}
		res = res.Next
	}
	return head.Next

}
