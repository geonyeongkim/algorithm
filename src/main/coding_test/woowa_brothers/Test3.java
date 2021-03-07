package main.coding_test.woowa_brothers;

import java.util.HashMap;
import java.util.Map;

public class Test3 {

    private static final String SAFE_PASS = "OK";

    public int solution(String[] T, String[] R) {
        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < T.length; i++) {
            for(int j = 0; j < T[i].length(); j++) {
                if(T[i].charAt(j) >= '1' && T[i].charAt(j) <= '9') {
                    // 그룹이 자연수이기에 10의 자리가 넘어가는 케이스를 위해 로직 추가
                    int endIdx = T[i].length();
                    for(int q = T[i].length() - 1; q >= j + 1; q--) {
                        if(T[i].charAt(q) >= 'a' && T[i].charAt(q) <= 'z') {
                            endIdx = q;
                            break;
                        }
                    }

                    String group = T[i].substring(0, endIdx);
                    if(map.get(group) == null && R[i].equals(SAFE_PASS)) {
                        map.put(group, true);
                    } else if(map.get(group) == null && !R[i].equals(SAFE_PASS)) {
                        map.put(group, false);
                    } else if(map.get(group) && !R[i].equals(SAFE_PASS)) {
                        map.put(group, false);
                    }
                    break;
                }
            }
        }

        int passCnt = 0;

        for (boolean value : map.values()) {
            if(value) passCnt++;
        }

        return passCnt * 100 / map.size();
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int ans = test3.solution(new String[]{"test1a", "test2", "test1b", "test1c", "test3"}, new String[]{"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"});
        System.out.println(ans);

        ans = test3.solution(new String[]{"codility1", "codility3", "codility2", "codility4b", "codility4a"}, new String[]{"Wrong answer", "OK", "OK", "Runtime error", "OK"});
        System.out.println(ans);

        ans = test3.solution(new String[]{"codility1", "codility3", "codility2", "codility4b", "codility4a"}, new String[]{"Wrong answer", "OK", "OK", "OK", "Runtime error"});
        System.out.println(ans);

        ans = test3.solution(new String[]{"codility11", "codility31", "codility21", "codility41b", "codility41a"}, new String[]{"Wrong answer", "OK", "OK", "OK", "Runtime error"});
        System.out.println(ans);
    }
}
