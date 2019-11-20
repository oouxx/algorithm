package com.wxx.leetcode.code_540;
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,7,7,10,11,11};
        int res = singleNonDuplicate(nums);
        System.out.println(res);
    }
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while ( l < h){
            int m = l + (h - l) / 2;
            if(m%2 == 1){
                m--;
            }
            if(nums[m] == nums[m + 1]){
                l = m + 2;
            }else{
                h = m;
            }
        }
        return nums[l];
    }
}