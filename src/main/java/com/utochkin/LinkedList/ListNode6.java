package com.utochkin.LinkedList;

// Add Two Numbers
public class ListNode6 {

    private int val;
    private ListNode6 next;

    ListNode6(int val) {
        this.val = val;
    }

    ListNode6() {
    }

    ListNode6(int val, ListNode6 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode6{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        ListNode6 l12 = new ListNode6(3);
        ListNode6 l11 = new ListNode6(2, l12);
        ListNode6 l1 = new ListNode6(1, l11);
        // 1 → 2 → 3 → null

        ListNode6 l22 = new ListNode6(6);
        ListNode6 l21 = new ListNode6(5, l22);
        ListNode6 l2 = new ListNode6(4, l21);
        // 4 → 5 → 6 → null

        // Explanation: 321 + 654 = 975.

        System.out.println(addTwoNumbers(l1, l2));
        // 5 → 7 → 9 → null
    }

    public static ListNode6 addTwoNumbers(ListNode6 l1, ListNode6 l2) {

        ListNode6 dummy = new ListNode6(); // «фиктивная» голова для удобства
        ListNode6 current = dummy;
        int carry = 0; // перенос (0 или 1)

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // новый перенос (0 или 1)
            int digit = sum % 10; // цифра для текущего узла

            current.next = new ListNode6(digit);
            current = current.next;
        }

        return dummy.next; // пропускаем фиктивную голову

    }
}
