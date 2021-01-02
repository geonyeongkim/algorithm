package main.programmers;

public class Dp3 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n][m];

        for (int[] puddle : puddles) {
            arr[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        arr[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) continue;

                if(i != 0) {
                    int a = arr[i - 1][j] == -1 ? 0 : arr[i - 1][j];
                    arr[i][j] += a % 1000000007;
                }

                if(j !=0 ){
                    int b = arr[i][j - 1] == -1 ? 0 : arr[i][j - 1];
                    arr[i][j] += b % 1000000007;
                }
            }
        }
        return arr[n - 1][m - 1] % 1000000007;
    }

    public static void main(String[] args) {
        Dp3 dp3 = new Dp3();
        int ans1 = dp3.solution(4, 3, new int[][]{{2, 2}});
        System.out.println("ans1 => " + ans1);

        int ans2 = dp3.solution(4, 4, new int[][]{{3, 2}, {2, 4}});
        System.out.println("ans2 => " + ans2);

        int ans3 = dp3.solution(5, 3, new int[][]{{4,2}});
        System.out.println("ans3 => " + ans3);

        int ans4 = dp3.solution(2, 2, new int[][]{{2,1}, {1, 2}});
        System.out.println("ans4 => " + ans4);

        int ans5 = dp3.solution(3, 1, new int[][]{{2,1}});
        System.out.println("ans5 => " + ans5);
    }
}
