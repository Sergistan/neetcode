package com.utochkin.Graphs;

import java.util.Arrays;
/*
Нужно найти все O, которые полностью окружены X и заменить их на X.

Если область O касается края: она НЕ окружена. Потому что у неё есть “выход наружу”.

Поэтому идея решения такая: Вместо того чтобы искать окружённые O мы делаем наоборот: ищем безопасные O, т.е. все O, которые связаны с границей.
 */
public class Surrounded_Regions {

    private static int ROWS, COLS;

    public static void main(String[] args) {

        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'O'}
        };

        solve(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    public static void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {   // левая граница
                capture(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') { // правая граница
                capture(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {  // верхняя граница
                capture(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {  // нижняя граница
                capture(board, ROWS - 1, c);
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private static void capture(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }
}

