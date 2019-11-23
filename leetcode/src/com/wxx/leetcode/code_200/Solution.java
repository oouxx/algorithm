package com.wxx.leetcode.code_200;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();    
        char[][] grid = new char[][]{{'1','1','0','0','0'},
                                    {'1','1','0','0','0'},
                                    {'0','0','1','0','0'},
                                    {'0','0','0','1','1'}};
        int res = s.numIslands(grid);
        System.out.println(res);
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int count = 0;
        for(int i = 0; i <= m ; i++){
            for(int j = 0; j <= n; j++){
                if(grid[i][j] != '0'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != '0'){
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
        }
    }
}

/**

public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
        return 0;
    }
    int m, n;
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    m = grid.length;
    n = grid[0].length;
    int islandsNum = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] != '0') {
                dfs(grid, direction, i, j);
                islandsNum++;
            }
        }
    }
    return islandsNum;
}

public void dfs(char[][] grid, int[][] direction, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
        return;
    }
    grid[i][j] = '0';
    for (int[] d : direction) {
        dfs(grid, direction, i + d[0], j + d[1]);
    }
}

 */