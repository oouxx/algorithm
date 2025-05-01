package main

/*
线段树可用于计算几何和 地理信息系统领域。例如，距中心参考点/原点一定距离的空间中可能会有大量点。
假设我们要查找距原点一定距离范围内的点。一个普通的查找表将需要对所有可能的点或所有可能的距离进
行线性扫描（假设是散列图）。线段树使我们能够以对数时间实现这一需求，而所需空间却少得多。这样的
问题称为 平面范围搜索。有效地解决此类问题至关重要，尤其是在处理动态数据且瞬息万变的情况下（例如，
用于空中交通的雷达系统）
*/
type SegmentTree struct{
	data, tree, lazy []int
	left, right int
	merge func(i, j int) int
}

// Init define
func (st *SegmentTree) Init(nums []int, oper func(i, j int)int){
	st.merge = oper
	data, tree ,lazy := make([]int, len(nums)), make([]int, 4*len(nums)), make([]int, 4*len(nums))
	for i:=0; i < len(nums); i++{
		data[i] = nums[i]
	}
	st.data, st.tree, st.lazy = data, tree, lazy
	if len(nums) > 0 {
		st.buildSegmentTree(0, 0, len(nums) - 1)
	}
}

// 在 treeIndex 的位置创建 [left......right] 区间的线段树
func (st *SegmentTree) buildSegmentTree(treeIndex, left, right int){
	if left == right{
		st.tree[treeIndex] = st.data[left]
		return
	}
	midTreeIndex, leftTreeIndex, rightTreeIndex := left+(right-left)>>1 , st.leftChild(treeIndex), st.rightChild(treeIndex)
	st.buildSegmentTree(leftTreeIndex, left, midTreeIndex)
	st.buildSegmentTree(rightTreeIndex, midTreeIndex + 1, right)
	st.tree[treeIndex] = st.merge(st.tree[leftTreeIndex], st.tree[rightTreeIndex])
}

func(st *SegmentTree) leftChild(index int) int{
	return 2*index + 1
}
func(st *SegmentTree) rightChild(index int) int{
	return 2*index + 2
}

// query define
func (st *SegmentTree) Query(left, right int) int {
	if len(st.data) > 0 {
		return st.queryInTree(0, 0, len(st.data) - 1, left, right)
	}
	return 0
}
// 在以 treeIndex 为根的线段树中 [left......right] 的范围里， 搜索区间[queryLeft...queryRight] 的值

func (st *SegmentTree) queryInTree(treeIndex, left, right, queryLeft, queryRight int) int{
	if left == queryLeft && right == queryRight{
		return st.tree[treeIndex]
	}
	midTreeIndex, leftTreeIndex, rightTreeIndex := left+(right-left)>>1 , st.leftChild(treeIndex), st.rightChild(treeIndex)
	if queryLeft > midTreeIndex{
		return st.queryInTree(rightTreeIndex, midTreeIndex + 1, right, queryLeft, queryRight)
	}else if queryRight <= midTreeIndex{
		return st.queryInTree(leftTreeIndex, left, midTreeIndex, queryLeft, queryRight)
	}
	return st.merge(st.queryInTree(leftTreeIndex, left, midTreeIndex, queryLeft, queryRight),
	st.queryInTree(rightTreeIndex, midTreeIndex + 1, right, midTreeIndex + 1, queryRight))
}
// QueryLazy define
func (st *SegmentTree) QueryLazy(left, right int) int{
	if len(st.data) > 0 {
		return st.queryLazyInTree(0, 0, len(st.data) - 1,left, right)
	}
	return 0
}

func (st *SegmentTree) queryLazyInTree(treeIndex, left, right, queryLeft, queryRight int) int{
	midTreeIndex, leftTreeIndex, rightTreeIndex := left+(right - left)>>1, st.leftChild(treeIndex), st.rightChild(treeIndex)
	if left > queryRight || right < queryLeft{
		return 0
	}
	if st.lazy[treeIndex] != 0{
		for i:= 0 ; i < right - left + 1; i++{
			st.tree[treeIndex] = st.merge(st.tree[treeIndex], st.lazy[treeIndex])
		}
		if left != right{
			st.lazy[leftTreeIndex] = st.merge(st.lazy[leftTreeIndex], st.lazy[treeIndex])
			st.lazy[rightTreeIndex] = st.merge(st.lazy[rightTreeIndex], st.lazy[treeIndex])
		}
		st.lazy[treeIndex] = 0
	}
	if queryLeft <= left && queryRight >= right{
		return st.tree[treeIndex]
	}
	if queryLeft > midTreeIndex {
		return st.queryLazyInTree(rightTreeIndex, midTreeIndex+1, right, queryLeft, queryRight)
	} else if queryRight <= midTreeIndex {
		return st.queryLazyInTree(leftTreeIndex, left, midTreeIndex, queryLeft, queryRight)
	}
	// merge query results
	return st.merge(st.queryLazyInTree(leftTreeIndex, left, midTreeIndex, queryLeft, midTreeIndex),
		st.queryLazyInTree(rightTreeIndex, midTreeIndex+1, right, midTreeIndex+1, queryRight))
}