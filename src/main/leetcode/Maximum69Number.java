package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-17
 */
public class Maximum69Number {

    public int maximum69Number (int num) {
        int ans = num;

        String numStr = String.valueOf(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numStr.length(); i++) {
            for(int j = 0; j < numStr.length(); j++) {
                char a;
                if(i == j){
                    if(numStr.charAt(j) == '9') a = '6';
                    else a = '9';
                } else {
                    a = numStr.charAt(j);
                }
                sb.append(a);
            }
            ans = Math.max(ans, Integer.valueOf(sb.toString()));
            sb.setLength(0);
        }

        return ans;
    }

    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();
        int ans1 = maximum69Number.maximum69Number(9669);
        System.out.println("ans1 -> " + ans1);

        int ans2 = maximum69Number.maximum69Number(9996);
        System.out.println("ans2 -> " + ans2);

        int ans3 = maximum69Number.maximum69Number(9999);
        System.out.println("ans3 -> " + ans3);
    }
}
