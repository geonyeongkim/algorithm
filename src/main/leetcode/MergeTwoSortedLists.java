package main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-01-25
 */
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode listNode1 = mergeTwoSortedLists.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
        System.out.println("listNode1 => " + listNode1);

        ListNode listNode2 = mergeTwoSortedLists.mergeTwoLists(new ListNode(), new ListNode());
        System.out.println("listNode2 => " + listNode2);

        ListNode listNode3 = mergeTwoSortedLists.mergeTwoLists(new ListNode(), new ListNode(0));
        System.out.println("listNode3 => " + listNode3);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();

        while(l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }

        if(list.size() == 0) {
            return null;
        }

        Collections.sort(list);

        ListNode ansewr = new ListNode(list.get(0));
        ListNode curr = ansewr;
        for (int i = 1; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }

        return ansewr;

    }
}
