package math

import "math"

func countPoints(points [][]int, queries [][]int) []int {
	answer := make([]int, len(queries))
	for k, q := range queries {
		for _, p := range points {
			x1 := float64(p[0])
			x2 := float64(q[0])
			y1 := float64(p[1])
			y2 := float64(q[1])
			r := float64(q[2])
			distance := math.Sqrt(math.Pow(x1-x2, 2) + math.Pow(y1-y2, 2))
			if distance <= r {
				answer[k]++
			}
		}
	}
	return answer
}
