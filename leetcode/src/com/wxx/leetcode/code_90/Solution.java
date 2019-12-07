package com.wxx.leetcode.code_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempSet = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        for (int size = 0; size < nums.length; size++) {
            backTracking(res, tempSet, 0, size, nums, hasVisited);
        }
        return res;
    }

    public void backTracking(List<List<Integer>> res, List<Integer> tempSet, int start, final int size, int[] nums,
            boolean[] hasVisited) {
        if (tempSet.size() == size) {
            res.add(new ArrayList<>(tempSet));
        }
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            tempSet.add(nums[i]);
            hasVisited[i] = true;
            backTracking(res, tempSet, i + 1, size, nums, hasVisited);
            hasVisited[i] = false;
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
