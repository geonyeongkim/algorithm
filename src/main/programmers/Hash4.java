package main.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by geonyeong.kim on 2020-12-18
 */
public class Hash4 {

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> map = new HashMap<>();
        List<Temp> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            list.add(new Temp(i, genres[i], plays[i]));
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Integer> answerList = new ArrayList<>();

        Map<String, List<Temp>> groupList = list.stream().collect(Collectors.groupingBy(Temp::getType));

        List<Map.Entry<String, Integer>> sortList = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparingInt(o -> -o))).collect(Collectors.toList());

        for(Map.Entry<String, Integer> entry : sortList) {
            List<Temp> tempList = groupList.get(entry.getKey());
            Comparator<Temp> comparator = Comparator.comparing(o -> -o.cnt);
            Collections.sort(tempList, comparator.thenComparing(Temp::getIdx));

            for (int i = 0; i < tempList.size(); i++) {
                if(i >= 2) break;
                answerList.add(tempList.get(i).getIdx());
            }
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Hash4 hash4 = new Hash4();
        int[] ans1 = hash4.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        for(int i : ans1) {
            System.out.println("i -> " + i);
        }
    }

    static class Temp {
        private int idx;
        private String type;
        private int cnt;

        public Temp(int idx, String type, int cnt) {
            this.idx = idx;
            this.type = type;
            this.cnt = cnt;
        }

        public int getIdx() {
            return idx;
        }

        public String getType() {
            return type;
        }

        public int getCnt() {
            return cnt;
        }

        @Override
        public String toString() {
            return "Temp{" +
                    "idx=" + idx +
                    ", type='" + type + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
