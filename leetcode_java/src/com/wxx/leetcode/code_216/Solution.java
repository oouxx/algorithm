package com.wxx.leetcode.code_216;

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(combineList, combinations, 1, k, n);
        return combinations;
    }

    private void backtracking(List<Integer> combineList, List<List<Integer>> combinations, int start, int k, int n) {
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {  // 剪枝
            combineList.add(i);
            backtracking(combineList, combinations, i + 1, k - 1, n - i);
            combineList.remove(combineList.size() - 1);
        }
    }
}