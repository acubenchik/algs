package com.acubenchik.leetcode;

//https://leetcode.com/problems/surrounded-regions/
public class FindSurroundedRegions {

    public static void main(String[] args) {
        char[][] multi = new char[][]{
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X'  },
                { 'X', 'O', 'X' , 'X' },
                { 'X', 'X', 'X' , 'X' }

        };
        new FindSurroundedRegions().solve(multi);
    }


    public void solve(char[][] board) {
        for(int i =0; i < board[0].length; i++) {
            dfs(board,0, i);
            dfs(board,board.length-1, i);
        }

        for(int i=0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 1) board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(board[i][j] != 'O')
            return;
        board[i][j] = 1;
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

}
