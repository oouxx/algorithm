package com.wxx.leetcode.code_40;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), combinations, new boolean[candidates.length], 0, target, candidates);
        return combinations;
    }

    public void backtracking(List<Integer> tempCombination, List<Integer> combinations, boolean a, int low, int target,
            int[] candidates) {
    }

}
