package main.programmers;

/**
 * Created by geonyeong.kim on 2021-01-05
 */
public class DfsBfs3 {

    int answer = Integer.MAX_VALUE;

    private void dfs(String begin, String target, String[] words, int cnt, boolean[] check) {

        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        boolean flag = true;

        for (boolean b : check) {
            if (!b) {
                flag = false;
                break;
            }
        }

        if (flag) {
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(!check[i]) {
                boolean res = checkAlphabet(begin, words[i]);
                if(res) {
                    check[i] = true;
                    dfs(words[i], target, words, cnt + 1, check);
                    check[i] = false;
                }
            }
        }
    }

    private boolean checkAlphabet(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < b.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt == 1;
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] check = new boolean[words.length];
        dfs(begin, target, words, 0, check);
        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        DfsBfs3 dfsBfs3 = new DfsBfs3();
        int ans1 = dfsBfs3.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println("ans1 => " + ans1);

        dfsBfs3 = new DfsBfs3();
        int ans2 = dfsBfs3.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println("ans2 => " + ans2);
    }
}
