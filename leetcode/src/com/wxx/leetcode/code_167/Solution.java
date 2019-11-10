package com.wxx.leetcode.code_167;
class Solution {
    public int[] twoSum(int[] numbers, int target) {
		if (numbers == null) {
			return null;
		}
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			}else if (sum > target) {
				j--;
			}else {
				return new int[] {i + 1, j + 1};
			}
		}
		return null;	
    }
}