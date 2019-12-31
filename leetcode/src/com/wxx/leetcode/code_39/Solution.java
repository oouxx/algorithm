package com.wxx.leetcode.code_39;

import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(res, tempList, candidates, target, 0);
        return res;
    }
    public void backTracking(List<List<Integer>> res, List<Integer> tempList, final int[] candidates, int target, int start){
        if(target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] <= target){
                tempList.add(candidates[i]);
                backTracking(res, tempList, candidates, target - candidates[i], i); // 下一次递归从i开始保证可以重复
                tempList.remove(tempList.size() - 1);
            }
        }
    }
} 