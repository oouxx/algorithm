package math

import "math"

func minOperations(boxes string) []int {
	answer := make([]int, len(boxes))
	for k := range boxes {
		for k1, v := range boxes {
			if v == '1' {
				answer[k] = answer[k] + int(math.Abs(float64(k1)-float64(k))*1)
			}
		}
	}
	return answer
}
