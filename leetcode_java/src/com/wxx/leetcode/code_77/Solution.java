package com.wxx.leetcode.code_77;

import java.util.*;

class Solution{
  public List<List<Integer>> combine(int n, int k){
    if(n <= 0 || k <= 0){
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    backTracking(res, tempList, 1, k, n);
    return res;
  }
  public void backTracking(List<List<Integer>> res, List<Integer> tempList, int start, int k, int n){
    if(k == 0){
      res.add(new ArrayList<>(tempList));
      return;
    }
    for(int i = start; i <= n - k + 1; i++){
      tempList.add(i);
      backTracking(res, tempList, i + 1, k - 1, n);
      tempList.remove(tempList.size() - 1);
    }
  }
}
