package com.utochkin.LinkedList;

//Reverse Nodes in K-Group
public class ListNode8 {

    private int val;
    private ListNode8 next;

    ListNode8(int val) {
        this.val = val;
    }

    ListNode8() {
    }

    ListNode8(int val, ListNode8 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode8{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        ListNode8 five = new ListNode8(6);
        ListNode8 four = new ListNode8(5, five);
        ListNode8 three = new ListNode8(4, four);
        ListNode8 two = new ListNode8(3, three);
        ListNode8 one = new ListNode8(2, two);
        ListNode8 head = new ListNode8(1, one);
        // 1 → 2 → 3 → 4 → 5 → 6 → null

        System.out.println(reverseKGroup(head, 3));
        // 3 → 2 → 1 → 6 → 5 → 4 → null
    }

    public static ListNode8 reverseKGroup(ListNode8 head, int k) {
        ListNode8 dummy = new ListNode8(0, head);
        ListNode8 groupPrev = dummy;

        while (true) {
            ListNode8 kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode8 groupNext = kth.next;

            ListNode8 prev = kth.next;
            ListNode8 curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode8 tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode8 tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    public static ListNode8 getKth(ListNode8 curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
