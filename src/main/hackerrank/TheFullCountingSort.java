package main.hackerrank;

import java.util.*;

public class TheFullCountingSort {

    static void countSort(List<List<String>> arr) {
        List<List<String>> answer = new ArrayList<>(100);
        for(int i = 0; i < 100; i++) {
            answer.add(new ArrayList<>());
        }

        int half = arr.size() / 2;

        for(int i = 0; i < half; i++) {
            answer.get(Integer.parseInt(arr.get(i).get(0))).add("-");
        }

        for(int i = half; i < arr.size(); i++) {
            answer.get(Integer.parseInt(arr.get(i).get(0))).add(arr.get(i).get(1));
        }

        StringBuilder sb = new StringBuilder();

        for (List<String> list : answer) {
            if(list.size() > 0) {
                for (String s : list) {
                    sb.append(s + " ");
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        List<List<String>> q1 = new ArrayList<>();
        q1.add(Arrays.asList("0", "ab"));
        q1.add(Arrays.asList("6", "cd"));
        q1.add(Arrays.asList("0", "ef"));
        q1.add(Arrays.asList("6", "gh"));
        q1.add(Arrays.asList("4", "ij"));
        q1.add(Arrays.asList("0", "ab"));
        q1.add(Arrays.asList("6", "cd"));
        q1.add(Arrays.asList("0", "ef"));
        q1.add(Arrays.asList("6", "gh"));
        q1.add(Arrays.asList("0", "ij"));
        q1.add(Arrays.asList("4", "that"));
        q1.add(Arrays.asList("3", "be"));
        q1.add(Arrays.asList("0", "to"));
        q1.add(Arrays.asList("1", "be"));
        q1.add(Arrays.asList("5", "question"));
        q1.add(Arrays.asList("1", "or"));
        q1.add(Arrays.asList("2", "not"));
        q1.add(Arrays.asList("4", "is"));
        q1.add(Arrays.asList("2", "to"));
        q1.add(Arrays.asList("4", "the"));

        TheFullCountingSort.countSort(q1);
        System.out.println();

        List<List<String>> q2 = new ArrayList<>();
        q2.add(Arrays.asList("1", "e"));
        q2.add(Arrays.asList("2", "a"));
        q2.add(Arrays.asList("1", "b"));
        q2.add(Arrays.asList("3", "a"));
        q2.add(Arrays.asList("4", "f"));
        q2.add(Arrays.asList("1", "f"));
        q2.add(Arrays.asList("2", "a"));
        q2.add(Arrays.asList("1", "e"));
        q2.add(Arrays.asList("1", "b"));
        q2.add(Arrays.asList("1", "c"));
        TheFullCountingSort.countSort(q2);
    }
}
