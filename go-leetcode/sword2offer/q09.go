package gosword2offer

type CQueue struct {
	Stack1 []int
	Stack2 []int
}

func Constructor1() CQueue {
	return CQueue{}
}

// push node to tail
func (this *CQueue) AppendTail(value int) {
	this.Stack1 = append(this.Stack1, value)
}

// pop head node
func (this *CQueue) DeleteHead() int {
	if len(this.Stack2) == 0 && len(this.Stack1) == 0 {
		return -1
	} else if len(this.Stack2) == 0 && len(this.Stack1) != 0 {
		for i := len(this.Stack1) - 1; i >= 0; i-- {
			this.Stack2 = append(this.Stack2, this.Stack1[i])
		}
		this.Stack1 = []int{}
	}
	temp := this.Stack2[len(this.Stack2)-1]
	this.Stack2 = this.Stack2[:len(this.Stack2)-1]
	return temp
}
