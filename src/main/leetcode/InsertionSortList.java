package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-03
 */

// TODO: 풀다가 집감...
public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {

        ListNode next = null, current = null, before = null, start = null;

        while(true) {
            if(next == null && current == null) {
                start = head;
                current = head;
                next = head.next;
                continue;
            }

            while(current != null) {
                if(current.val > next.val) {
                    start = next;
                    current.next = next.next;
                    next.next = current;
                    if(before != null) {
                        before.next = next;
                    }
                    before = null;
                    head = next;
                    break;
                } else {
                    before = current;
                    current = current.next;
                }
            }

            if(current.next == null) {
                break;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
//        ListNode listNode4 = new ListNode(3);

        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        ListNode res = insertionSortList(listNode1);
        System.out.println("res -> " + res);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
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
