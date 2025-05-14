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
    backTracking(res, tempSet, 0, nums);
    return res;
  }

  public void backTracking(List<List<Integer>> res, List<Integer> tempSet, int start, int[] nums) {
    res.add(tempSet);
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      List<Integer> ntempSet = new ArrayList<>(tempSet);
      ntempSet.add(nums[i]);
      backTracking(res, ntempSet, i + 1, nums);
    }
  }
}
/**
 * public class Solution { public List<List<Integer>> subsetsWithDup(int[] nums)
 * { Arrays.sort(nums); List<List<Integer>> result = new ArrayList<>();
 * dfs(nums, 0, new ArrayList<Integer>(), result); return result; }
 * 
 * public void dfs(int[] nums, int index, List<Integer> path,
 * List<List<Integer>> result) { result.add(path); for (int i = index; i <
 * nums.length; i++) { if (i > index && nums[i] == nums[i - 1]) continue;
 * List<Integer> nPath = new ArrayList<>(path); nPath.add(nums[i]); dfs(nums, i
 * + 1, nPath, result); } } }
 */
