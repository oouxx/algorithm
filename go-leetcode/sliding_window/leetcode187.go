package slidingwindow

// 滑动窗口

func findRepeatedDnaSequences(s string) []string {
	allSeqs := make(map[string]bool)
	repeatedSeqs := make(map[string]bool)
	for i := 0; i <= len(s)-10; i++ {
		subSeq := s[i : i+10]
		if allSeqs[subSeq] {
			repeatedSeqs[subSeq] = true
		} else {
			allSeqs[subSeq] = true
		}
	}
	result := make([]string, 0, len(repeatedSeqs))
	for k := range repeatedSeqs {
		result = append(result, k)
	}
	return result
}

func findRepeatedDnaSequences2(s string) []string {
	seqCount := make(map[string]int)
	var result []string
	for i := 0; i <= len(s)-10; i++ {
		seq := s[i : i+10]
		seqCount[seq]++
		if seqCount[seq] == 2 {
			result = append(result, seq)
		}
	}
	return result
}
