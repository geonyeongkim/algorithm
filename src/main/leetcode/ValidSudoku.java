package main.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> columns = new ArrayList<>();
        List<Set<Character>> subs = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            subs.add(new HashSet<>());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(rows.get(i).contains(board[i][j])) {
                        return false;
                    }
                    rows.get(i).add(board[i][j]);

                    if(columns.get(j).contains(board[i][j])) {
                        return false;
                    }
                    columns.get(j).add(board[i][j]);

                    int subsIndex = 0;
                    if (i >= 0 && i <= 2 && j >= 0 && j <= 2) {
                        subsIndex = 0;
                    } else if(i >= 0 && i <= 2 && j >= 3 && j <= 5) {
                        subsIndex = 1;
                    } else if(i >= 0 && i <= 2 && j >= 6 && j <= 8) {
                        subsIndex = 2;
                    } else if(i >= 3 && i <= 5 && j >= 0 && j <= 2) {
                        subsIndex = 3;
                    } else if(i >= 3 && i <= 5 && j >= 3 && j <= 5) {
                        subsIndex = 4;
                    } else if(i >= 3 && i <= 5 && j >= 6 && j <= 8) {
                        subsIndex = 5;
                    } else if(i >= 6 && i <= 8 && j >= 0 && j <= 2) {
                        subsIndex = 6;
                    } else if(i >= 6 && i <= 8 && j >= 3 && j <= 5) {
                        subsIndex = 7;
                    } else if(i >= 6 && i <= 8 && j >= 6 && j <= 8) {
                        subsIndex = 8;
                    }

                    if(subs.get(subsIndex).contains(board[i][j])) {
                        return false;
                    }
                    subs.get(subsIndex).add(board[i][j]);

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        boolean ans1 = validSudoku.isValidSudoku(new char[][]
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}});
        System.out.println(ans1);

        boolean ans2 = validSudoku.isValidSudoku(new char[][]
                {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}});
        System.out.println(ans2);
    }
}
