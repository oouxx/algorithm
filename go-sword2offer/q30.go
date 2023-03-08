package gosword2offer

type MinStack struct {
	Value    []int
	minValue []int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{}

}

func (this *MinStack) Push(x int) {
	this.Value = append(this.Value, x)
	if len(this.minValue) == 0 || x <= this.minValue[len(this.minValue)-1] {
		this.minValue = append(this.minValue, x)
	}
}

func (this *MinStack) Pop() {
	val := this.Value[len(this.Value)-1]
	this.Value = this.Value[:len(this.Value)-1]
	if val == this.minValue[len(this.minValue)-1] {
		this.minValue = this.minValue[:len(this.minValue)-1]
	}
}

func (this *MinStack) Top() int {
	return this.Value[len(this.Value)-1]
}

func (this *MinStack) Min() int {
	return this.minValue[len(this.minValue)-1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Min();
 */
