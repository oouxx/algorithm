package com.wxx.leetcode.code_34;
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.searchRange(new int[]{2, 2}, 2);
        System.out.println(res);

    }
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if(first >= nums.length || nums[first] != target){
            return new int[]{-1, -1};
        }else{
            return new int[]{first, Math.max(first, last)};
        }
    }
    public int binarySearch(int[] nums, int target){
        int l = 0;
        int h = nums.length; // attention h initial value
        while( l < h){
            int m = l + (h - l) / 2;
            if(nums[m] >= target){
                h = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }
}