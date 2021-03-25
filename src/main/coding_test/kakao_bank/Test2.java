package main.coding_test.kakao_bank;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

    private class Account {
        private String id;
        private long max;
        private long current;

        public Account(String id, long max, long current) {
            this.id = id;
            this.max = max;
            this.current = current;
        }

        public String getId() {
            return id;
        }

        public long getMax() {
            return max;
        }

        public long getCurrent() {
            return current;
        }

        public void setCurrent(long current) {
            this.current = current;
        }
    }

    private enum Code {
        SUCCESS(200),
        REJECT(403),
        NOT_FOUND(404)
        ;

        private final int code;

        Code(int code) {
            this.code = code;
        }
    }



    public int[] solution(String[] reqs) {
        int[] answer = new int[reqs.length];

        int idx = 0;

        Map<String, Account> map = new HashMap<>();

        for (String req : reqs) {
            String[] arr = req.split(" ");

            switch (arr[0]) {
                case "CREATE":
                    if(map.containsKey(arr[1])) {
                        answer[idx++] = Code.REJECT.code;
                    } else {
                        map.put(arr[1], new Account(arr[1], -Long.valueOf(arr[2]), 0));
                        answer[idx++] = Code.SUCCESS.code;
                    }
                    break;
                case "DEPOSIT":
                    if(!map.containsKey(arr[1])) {
                        answer[idx++] = Code.NOT_FOUND.code;
                    } else {
                        Account account = map.get(arr[1]);
                        account.setCurrent(account.getCurrent() + Long.valueOf(arr[2]));
                        answer[idx++] = Code.SUCCESS.code;
                    }
                    break;
                case "WITHDRAW":
                    if(!map.containsKey(arr[1])) {
                        answer[idx++] = Code.NOT_FOUND.code;
                    } else {
                        Account account = map.get(arr[1]);
                        if (account.getCurrent() - Long.valueOf(arr[2]) < account.getMax()) {
                            answer[idx++] = Code.REJECT.code;
                        } else {
                            account.setCurrent(account.getCurrent() - Long.valueOf(arr[2]));
                            answer[idx++] = Code.SUCCESS.code;
                        }

                    }
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] ans = test2.solution(new String[]{"DEPOSIT 3a 10000", "CREATE 3a 300000", "WITHDRAW 3a 150000", "WITHDRAW 3a 150001"});
        for (int i : ans) {
            System.out.println(i + " ");
        }
        System.out.println();

        ans = test2.solution(new String[]{"CREATE 3a 10000", "CREATE 3a 20000", "CREATE 2bw 30000"});
        for (int i : ans) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
}
