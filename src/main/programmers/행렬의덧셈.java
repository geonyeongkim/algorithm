package main.programmers;

/**
 * Created by geonyeong.kim on 2021-01-14
 */
public class 행렬의덧셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][];

        for (int i = 0; i < arr1.length; i++) {
            answer[i] = new int[arr1[i].length];
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        행렬의덧셈 c = new 행렬의덧셈();
        int[][] ans1 = c.solution(new int[][]{{1,2}, {2,3}}, new int[][]{{3,4}, {5,6}});
        for (int[] ints : ans1) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println();
        }

        int[][] ans2 = c.solution(new int[][]{{1}, {2}}, new int[][]{{3}, {4}});
        for (int[] ints : ans2) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println();
        }
    }
}
