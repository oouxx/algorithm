package com.wxx.leetcode.code_75;
class Solution {
    public void sortColors(int[] nums) {
        int left = -1;
        int start = 0;
        int end = nums.length;
        while(start < end){
            if(nums[start] == 0){
                swap(nums, ++left, start++);
            }else if (nums[start] == 2){
                swap(nums, start, --end);
            }else{
                start++;
            }
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}