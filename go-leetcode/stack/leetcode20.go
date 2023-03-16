package stack

type stack []rune

func (s *stack) Push(v rune) {
	*s = append(*s, v)
}

func (s *stack) Pop() rune {
	res := (*s)[len(*s)-1]
	*s = (*s)[:len(*s)-1]
	return res
}

func (s *stack) Len() int {
	return len(*s)
}

func isValid(s string) bool {
	mstack := new(stack)
	for _, v := range s {
		if v == '(' || v == '[' || v == '{' {
			mstack.Push(v)
		}
		switch v {
		case ')':
			// 判断stack元素数量，解决括号数量不匹配问题
			if mstack.Len() == 0 {
				return false
			}
			val := mstack.Pop()
			if val != '(' {
				return false
			}
		case ']':
			if mstack.Len() == 0 {
				return false
			}
			val := mstack.Pop()
			if val != '[' {
				return false
			}
		case '}':
			if mstack.Len() == 0 {
				return false
			}
			val := mstack.Pop()
			if val != '{' {
				return false
			}
		}
	}
	return mstack.Len() == 0
}
