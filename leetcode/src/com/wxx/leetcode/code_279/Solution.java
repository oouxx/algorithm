package com.wxx.leetcode.code_279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /**
     * bfs+动态规划
     * @param n
     * @return
     */
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     * @return 1,4,9,...
     */
    public List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}

// class Solution{
//     public int numSquares(int n) {
//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, Integer.MAX_VALUE);
//         dp[0] = 0;
//         for(int i = 1; i <= n; ++i) {
//             int min = Integer.MAX_VALUE;
//             int j = 1;
//             while(i - j*j >= 0) {
//                 min = Math.min(min, dp[i - j*j] + 1);
//                 ++j;
//             }
//             dp[i] = min;
//         }		
//         return dp[n];
//     }
// }