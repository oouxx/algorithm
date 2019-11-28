package com.wxx.leetcode.code_79;
/**
 * For String, StringBuffer, and StringBuilder, charAt() is a constant-time operation.
 * For StringBuffer and StringBuilder, deleteCharAt() is a linear-time operation.
 */
class Solution {
    private static int m;
    private static int n;
    public static void main(String[] args) {
        char[] w = new char[5];
        w[0] = 'a';
        w[0] ^= 256;
        System.out.println(w[0]);

    }
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0){
            return false;
        }
        char[] w = word.toCharArray();
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(existCore(board, w, 0, i, j)){
                    return true;

                }
            }
        }
        return false;
    }
    private boolean existCore(char[][] board, char[] word, int path, int x, int y){
        if(path >= word.length){
            return true;
        }
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != word[path]){
            return false;
        }
        board[x][y] ^= 256;
        boolean isExist = existCore(board, word, path + 1, x + 1, y)
                    || existCore(board, word, path + 1, x - 1, y)
                    || existCore(board, word, path + 1, x, y + 1)
                    || existCore(board, word, path + 1, x, y - 1);
        board[x][y] ^= 256;
        return isExist;
    }
}


/**
Runtime: 3 ms, faster than 99.99% of Java online submissions for Word Search.
Memory Usage: 38.8 MB, less than 92.86% of Java online submissions for Word Search.

private boolean exist(char[][] board, int y, int x, char[] word, int i) {
	if (i == word.length) return true;
	if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
	if (board[y][x] != word[i]) return false;
	board[y][x] ^= 256;
	boolean exist = exist(board, y, x+1, word, i+1)
		|| exist(board, y, x-1, word, i+1)
		|| exist(board, y+1, x, word, i+1)
		|| exist(board, y-1, x, word, i+1);
	board[y][x] ^= 256;
	return exist;
}
 */