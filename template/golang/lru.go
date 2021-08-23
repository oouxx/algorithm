package main

/*
import "container/list"

type LRUCache struct{
	Cap int
	Keys map[int]*list.Element
	List *list.List
}

type pair struct{
	K, V int
}

func constructor (capacity int) LRUCache{
	return LRUCache{
		Cap: capacity,
		Keys: make(map[int]*list.Element),
		List: list.New(),
	}
}

func (c *LRUCache) Get(key int) int{
	if el, ok := c.Keys[key]; ok{
		c.List.MoveToFront(el)
		return el.Value.(pair).V
	}
	return -1
}

func (c *LRUCache) Put(key int, value int) {
	if el, ok := c.Keys[key]; ok{
		el.Value = pair{K: key, V: value}
		c.List.MoveToFront(el)
	}else{
		el := c.List.PushFront(pair{K: key, V: value})
		c.Keys[key] = el
	}
	if c.List.Len() > c.Cap{
		el := c.List.Back()
		c.List.Remove(el)
		// delete(c.Keys, el.Value.(pair).K)
	}
}
*/

type LRUCache struct{
	head, tail *Node
	Keys map[int]*Node
	Cap int
}
type Node struct{
	Key, Val int
	Prev, Next *Node
}
func constructor(capacity int) LRUCache{
	return LRUCache{Keys: make(map[int]*Node), Cap: capacity}
}

func (this *LRUCache) Get(key int) int{
	if node, ok := this.Keys[key]; ok{
		this.Remove(node)
		this.Add(node)
		return node.Val
	}
	return -1
}

func (this *LRUCache) Put(key , value int){
	if node, ok := this.Keys[key]; ok{
		node.Val = value
		this.Remove(node)
		this.Add(node)
		return
	}else{
		node = &Node{Key: key, Val: value}
		this.Keys[key] = node
		this.Add(node)
	}
	if len(this.Keys) > this.Cap{
		this.Remove(this.tail)
	}
}

func (this *LRUCache) Add(node *Node){
	node.Prev = nil
	node.Next = this.head
	if this.head != nil{
		this.head.Prev = node
	}
	this.head = node
	if this.tail == nil{
		this.tail = node
		this.tail.Next = nil
	}
}

func (this *LRUCache) Remove(node *Node){
	if node == this.head{
		this.head = node.Next
		node.Next = nil
		return
	}
	if node == this.tail{
		this.tail = node.Prev
		node.Prev.Next = nil
		node.Prev = nil
		return
	}
	node.Prev.Next = node.Next
	node.Next.Prev = node.Prev
}