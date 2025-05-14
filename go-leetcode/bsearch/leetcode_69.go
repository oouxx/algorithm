package bsearch

// leetcode 69 x的平方根

func MySqrt(x int) int {
	left := 1
	right := x / 2
	mid := (left + right) / 2
	for left < right {
		mid = (left + right) / 2
		if (mid*mid) < x && ((mid+1)*(mid+1)) < x {
			left = mid
		} else if (mid*mid) > x && ((mid-1)*(mid-1)) > x {
			right = mid
		} else if (mid*mid) < x && ((mid+1)*(mid+1)) > x || (mid*mid) > x && ((mid-1)*(mid-1)) < x {
			break
		}

	}
	if (mid * mid) < x {
		return mid

	}
	return mid - 1
}
func MySqrt2(x int) int {
	if x <= 1 {
		return x
	}
	left := 1
	right := x
	var mid int
	for left <= right {
		mid = (left + right) / 2
		sqrt := x / mid
		if sqrt == mid {
			return mid
		} else if sqrt < mid {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return right
}
