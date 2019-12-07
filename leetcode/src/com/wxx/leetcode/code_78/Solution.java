package com.wxx.leetcode.code_78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempSet = new ArrayList<>();
        for(int size = 0; size < nums.length; size++){
            backTracking(res, tempSet, 0, size, nums);
        }
        return res;
    }
    public void backTracking(List<List<Integer>> res, List<Integer> tempSet, int start, int size, int[] nums){
        if(tempSet.size() == size){
            res.add(new ArrayList<>(tempSet));
        }
        for(int  i = start; i < nums.length; i++){
            tempSet.add(nums[i]);
            backTracking(res, tempSet, i + 1, size, nums);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
