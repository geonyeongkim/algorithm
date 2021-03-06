package main.codility;

public class FrogJmp {

    public int solution(int X, int Y, int D) {
        int answer = 0;

        answer = (Y-X) / D;
        if((Y-X) % D != 0) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
        int ans = frogJmp.solution(10, 85, 30);
        System.out.println(ans);
    }
}
