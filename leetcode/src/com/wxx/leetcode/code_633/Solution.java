package com.wxx.leetcode.code_633;
class Solution{
	public boolean judgeSquareSum(int c) {
	    if (c < 0) {
	    	return false;
	    }
	    int i = 0;
	    int j = (int) Math.sqrt(c);
	    while (i <= j) {
	    	int squareSum = i * i + j * j;
	    	if (squareSum == c) {
	    		return true;
	    	}else if(squareSum < c) {
	    		i++;
	    	}else {
	    		j--;
	    	}
	    }
	    return false;
	}
}
