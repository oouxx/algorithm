package com.wxx.leetcode.code_300;
/**
 * time complexity O(n^2)
 */
class Solution{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{4,10,4,3,8,9};
        int res = s.lengthOfLIS(nums);
        System.out.println(res);
    }
    public int lengthOfLIS(int[] nums){
        int numsLength = nums.length;
        if(nums == null || numsLength == 0){
            return 0;
        }
        int[] dp = new int[numsLength];
        dp[0] = 1;
        for(int i = 1; i < numsLength; i++){
            int max = 1;
            for(int j = i - 1; j >=0 ;j-- ){
                if(nums[j] < nums[i]){
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
        }
        int ret = 0;
        for (int i = 0; i < numsLength; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}

/**
定义一个 tails 数组，其中 tails[i] 存储长度为 i + 1 的最长递增子序列的最后一个元素。对于一个元素 x，

如果它大于 tails 数组所有的值，那么把它添加到 tails 后面，表示最长递增子序列长度加 1；
如果 tails[i-1] < x <= tails[i]，那么更新 tails[i] = x。

public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] tails = new int[n];
    int len = 0;
    for (int num : nums) {
        int index = binarySearch(tails, len, num);
        tails[index] = num;
        if (index == len) {
            len++;
        }
    }
    return len;
}

private int binarySearch(int[] tails, int len, int key) {
    int l = 0, h = len;
    while (l < h) {
        int mid = l + (h - l) / 2;
        if (tails[mid] == key) {
            return mid;
        } else if (tails[mid] > key) {
            h = mid;
        } else {
            l = mid + 1;
        }
    }
    return l;
}
 */