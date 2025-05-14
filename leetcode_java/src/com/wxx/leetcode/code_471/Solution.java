package com.wxx.leetcode.code_471;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    /**
     * 求既能流到太平洋又能流到大西洋的位置
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }

        int m, n;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, direction, i, 0, canReachP);
            dfs(matrix, direction, i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, direction, 0, i, canReachP);
            dfs(matrix, direction, m - 1, i, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }

        return ret;
    }

    public void dfs(int[][] matrix, int[][] direction, int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= matrix.length || nextC < 0 || nextC >= matrix[0].length
                    || matrix[r][c] > matrix[nextR][nextC]) {

                continue;
            }
            dfs(matrix, direction, nextR, nextC, canReach);
        }
    }
}