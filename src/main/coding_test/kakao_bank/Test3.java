package main.coding_test.kakao_bank;

public class Test3 {

    private static int answer;

    int solution(int[][] board) {
        answer = -1;

        for(int i = 0; i < 4; i++) {
            bruteForce(board, 0, i);
        }

        return answer;
    }

    private void bruteForce(int[][] board, int cnt, int dir) {
        if(cnt == 5) {
            int val = -1;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    val = Math.max(val, board[i][j]);
                }
            }
            answer = Math.max(val, answer);
            return;
        }

        switch (dir) {
            // 위
            case 0:
                for (int i = 1; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] != 0) {
                            int curI = i;
                            for (int q = i - 1; q > -1; q--) {
                                if (board[q][j] == 0) {
                                    curI = q;
                                }
                            }
                            if (curI != i) {
                                board[curI][j] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                    }
                }
                for (int i = 1; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] == board[i - 1][j]) {
                            board[i - 1][j] = board[i - 1][j] + board[i][j];
                            for (int q = i; q < board.length - 1; q++) {
                                board[q][j] = board[q + 1][j];
                            }
                            board[board.length - 1][j] = 0;
                        }
                    }
                }
                break;
            // 왼
            case 1:
                for (int i = 0; i < board.length; i++) {
                    for (int j = 1; j < board[i].length; j++) {
                        if (board[i][j] != 0) {
                            int curJ = j;
                            for (int q = j - 1; q > -1; q--) {
                                if (board[i][q] == 0) {
                                    curJ = q;
                                }
                            }
                            if (curJ != j) {
                                board[i][curJ] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                    }
                }
                for (int i = 0; i < board.length; i++) {
                    for (int j = 1; j < board[i].length; j++) {
                        if (board[i][j] == board[i][j - 1]) {
                            board[i][j - 1] = board[i][j - 1] + board[i][j];
                            for (int q = j; q < board.length - 1; q++) {
                                board[i][q] = board[i][q + 1];
                            }
                            board[i][board[i].length - 1] = 0;
                        }
                    }
                }
                break;
            // 오른쪽
            case 2:
                for (int i = 0; i < board.length; i++) {
                    for (int j = board[i].length - 2; j > -1; j--) {
                        if (board[i][j] != 0) {
                            int curJ = j;
                            for (int q = j + 1; q < board[i].length; q++) {
                                if (board[i][q] == 0) {
                                    curJ = q;
                                }
                            }
                            if (curJ != j) {
                                board[i][curJ] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                    }
                }
                for (int i = 0; i < board.length; i++) {
                    for (int j = board[i].length - 2; j > -1; j--) {
                        if (board[i][j] == board[i][j + 1]) {
                            board[i][j + 1] = board[i][j + 1] + board[i][j];
                            for (int q = j; q > 0; q--) {
                                board[i][q] = board[i][q - 1];
                            }
                            board[i][0] = 0;
                        }
                    }
                }
                break;
            // 아래
            case 3:
                for (int i = board.length - 2; i > -1; i--) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] != 0) {
                            int curI = i;
                            for (int q = i + 1; q < board.length; q++) {
                                if (board[q][j] == 0) {
                                    curI = q;
                                }
                            }
                            if (curI != i) {
                                board[curI][j] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                    }
                }
                for (int i = board.length - 2; i > -1; i--) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] == board[i + 1][j]) {
                            board[i + 1][j] = board[i + 1][j] + board[i][j];
                            for (int q = i; q > 0; q--) {
                                board[q][j] = board[q - 1][j];
                            }
                            board[0][j] = 0;
                        }
                    }
                }
                break;
        }

        for (int i = 0; i < 4; i++) {
            bruteForce(board, cnt + 1, i);
        }
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int ans = test3.solution(new int[][]{{2, 4, 8, 2}, {2, 2, 2, 2}, { 0, 4, 2, 4}, {2, 2, 2, 4}});
        System.out.println(ans);
    }
}
