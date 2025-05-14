package com.wxx.leetcode.code_46;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> permutions = new ArrayList<>();
        List<Integer> tempPermution = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTracking(permutions, tempPermution, nums, visited);
        return permutions;
    }
    private void backTracking(List<List<Integer>> permutions, List<Integer> tempPermution, int[] nums, boolean[] visited){
        if(tempPermution.size() == nums.length){
            permutions.add(new ArrayList<>(tempPermution));
        }
        for(int i = 0; i < visited.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            tempPermution.add(nums[i]);
            backTracking(permutions, tempPermution, nums, visited);
            tempPermution.remove(tempPermution.size() - 1);
            visited[i] = false;
        }
    }
}

/**
 * 
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.permuteUnique(new int[]{1, 1, 3});
        System.out.println(res);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        int length = nums.length;
        List<List<Integer>> permutions = new ArrayList<>();
        permutions.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        backTracking(permutions, 0, length);
        return permutions;
    }
    private void backTracking(List<List<Integer>> permutions, int i, int length){
        if(i == length){
            return;
        }
        int size = permutions.size();
        for(int m = 0; m < size; m++){
            swap(permutions, new ArrayList<>(permutions.get(m)), i);
        }
        backTracking(permutions, i + 1, length);
    }
    private void swap(List<List<Integer>> permutions, List<Integer> tempPermution, int i){
        List<Integer> origin = new ArrayList<>(tempPermution);
        for(int m = i + 1; m < tempPermution.size();m++){
            Integer temp = tempPermution.get(i);
            tempPermution.set(i, tempPermution.get(m));
            tempPermution.set(m, temp);
            permutions.add(new ArrayList<>(tempPermution));
            tempPermution = origin;
        }
    }
}
 */