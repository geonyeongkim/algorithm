package main.leetcode;

/**
 * Created by geonyeong.kim on 2020-12-03
 */

/*
 * 문제 풀이를 참고했음...
 * 풀이 접근은 같았으나 dummy 의 ListNode 를 생성하지 않고, head에서 참조만 바꿔가면서 하려고 하여 문제를 풀지 못함.
 * 링크드 리스트 노드 문제의 경우 결과물의 링크드 리스트를 dummy로 만들고, 알고리즘의 점화식을 세워 dummy를 결과값으로 세팅하는 방법으로 접근해야 할 듯
 * */
/*
* 최악의 경우 시간 복잡도는 O(n^2) 가 나옴. 예를 들어) [1, 2, 3, 4, 5, 6] 와 같이 이미 정렬이 되어 있는 경우.
* 공간 복잡도는 dummy 하나만을 만들어 사용하기 때문에 O(1)
* */
public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;

            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }

            cur.next = prev.next;
            prev.next = cur;
            prev = dummy;
            cur = next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode res = insertionSortList(listNode1);
        System.out.println("res -> " + res);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

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
}
