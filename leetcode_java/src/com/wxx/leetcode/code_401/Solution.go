package main

func main() {

}

var nums = []int{1, 2, 4, 8, 1, 2, 4, 8, 16, 32}
var visited = []int{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
var resultAll []string

func readBinaryWatch(turnedOn int) []string {
	dfs(turnedOn, 0, 0)
	return resultAll
}

func dfs(num int, step int, start int) {
	if step == num {
		resultAll = append(resultAll, handleDate(visited))
		return
	}
	slice := nums[start:len(nums)]
	for i, v := range slice {
		visited[i] = 1
		//TODO

	}

}

func handleDate(visited []int) string {

}
