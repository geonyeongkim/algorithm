package main.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    /*
    * 내가 풀은 풀이.
    * 단순히, 각 노드에서 비교를 시작하도록 풀음.
    * 각 노드에서 탐색을 하므로 O(n^2) 발생. 안좋음.
    * */
    public static int[] myNextLargerNodes(ListNode head) {
        List<Integer> resList = new ArrayList<>();

        while(head != null) {
            ListNode cur = head;
            int v1 = head.val;
            int max = 0;
            while(head != null) {
                if(v1 < head.val) {
                    max = head.val;
                    break;
                }

                head = head.next;
            }
            resList.add(max);
            head = cur;
            head = head.next;
        }

        int[] res = new int[resList.size()];
        for(int i = 0; i <resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    /*
    * Stack을 이용하여 최적화 가능 -> List + Stack 조합
    * 먼저 list에 담고, stack에는 index 정보를 담으면서, 큰 숫자를 발견하면 stack을 이용하여 reverse for 문과 같이 작동하도록 하여 큰 값으로 덮음.
    * */
    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> al = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            al.add(temp.val);
            temp = temp.next;
        }

        //Arrays.fill(result,0) is not required since by default arrays have the value 0.
        int[] result = new int[al.size()];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<al.size();i++)
        {
            while(!stack.isEmpty() && al.get(stack.peek())<al.get(i))
                result[stack.pop()] = al.get(i);

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
//        [1,7,5,1,9,2,5,1]
        ListNode list1 = new ListNode(1, new ListNode(7, new ListNode(5, new ListNode(1, new ListNode(9, new ListNode(2, new ListNode(5, new ListNode(1))))))));
        System.out.println("list1 -> " + list1);

        int[] res = myNextLargerNodes(list1);
        for(int i : res) {
            System.out.println("i -> " + i);
        }
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
