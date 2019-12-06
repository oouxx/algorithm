package com.wxx.leetcode.code_77;

import java.util.*;

class Solution{
  public List<List<Integer>> combine(int n, int k){
    if(n <= 0 || k <= 0){
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    backTracking(res, tempList, 0, k, n);
    return res;
  }
  public void backTracking(List<List<Integer>> res, List<Integer> tempList, int length, int k, int n){
    if(length == k){
      res.add(new ArrayList<>(tempList));
      return;
    }
    for(int i = 1; i <= n; i++){
      tempList.add(i);
      backTracking(res, tempList, length + 1, k, n);
      tempList.remove(tempList.size() - 1);
    }
  }
}
