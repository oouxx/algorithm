package com.wxx.leetcode.code_130;
class Solution {
    /**
     *  先访问外部的，再访问内部的 
     * @param board
     */
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < m; i++){
            dfs(board, dirs, i, 0);
            dfs(board, dirs, i, n - 1);
        }
        for(int i = 0; i < n; i++){
            dfs(board, dirs, 0, i);
            dfs(board, dirs, m - 1, i);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    public void dfs(char[][] board, int[][] dirs, int i, int j){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O'){
            board[i][j] = 'T';
            for(int[] dir: dirs){
                dfs(board, dirs, i + dir[0], j + dir[1]);
            }
        }
    }
}