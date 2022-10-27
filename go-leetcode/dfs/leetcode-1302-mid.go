package dfs

// 广度优先搜索
func deepestLeavesSumWithBFS(root *TreeNode) (sum int) {
	q := []*TreeNode{root}
	for len(q) > 0 {
		sum = 0
		size := len(q)
		for i := 0; i < size; i++ {
			node := q[0]
			q = q[1:]
			sum += node.Val
			if node.Left != nil {
				q = append(q, node.Left)
			}
			if node.Right != nil {
				q = append(q, node.Right)
			}
		}
	}
	return
}

func deepestLeavesSumWithDFS(root *TreeNode) (sum int) {
	maxLevel := -1
	var dfs func(*TreeNode, int)

	dfs = func(node *TreeNode, level int) {
		if node == nil {
			return
		}
		// 如果level 比最大level大，sum重置为当前节点
		if level > maxLevel {
			maxLevel = level
			sum = node.Val
		} else if level == maxLevel { // 当前level等于最大level 累加
			sum += node.Val
		}
		// 左节点采用相同操作
		dfs(node.Left, level+1)
		// 右节点采用相同操作
		dfs(node.Right, level+1)
	}
	dfs(root, 0)
	return
}
