package com.wxx.leetcode.code_215;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int index = partition(nums, start, end);
            if(index == k){
                break;
            }else if (index < k){
                start = index + 1;
            }else{
                end = index - 1;
            }
        }
        return nums[k];
        
    }
    private int partition(int[] nums, int start, int end){
        int i = start - 1;
        int j = end;
        int num = nums[end];
        while (true){
            while (nums[++i] < num && i < end);
            while (nums[--j] > num && j > start);
            if (i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, i , end);
        return i;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}