package com.utochkin.LinkedList;
// Merge Two Sorted Linked Lists
public class ListNode2 {
    private int val;
    private ListNode2 next;

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2() {
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode2{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        ListNode2 two1 = new ListNode2(4);
        ListNode2 one1 = new ListNode2(2, two1);
        ListNode2 head1 = new ListNode2(1, one1);
        // 1 → 2 → 4 → null

        ListNode2 two2 = new ListNode2(5);
        ListNode2 one2 = new ListNode2(3, two2);
        ListNode2 head2 = new ListNode2(1, one2);
        // 1 → 3 → 5 → null

        System.out.println(mergeTwoLists(head1, head2));
        // 1 → 1 → 2 → 3 → 4 → 5 → null
    }

    public static ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {

        ListNode2 dummy = new ListNode2();
        ListNode2 current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;  // Добавляем узел из list1
                list1 = list1.next;   // Переходим к следующему узлу list1
            } else {
                current.next = list2;  // Добавляем узел из list2
                list2 = list2.next;    // Переходим к следующему узлу list2
            }
            current = current.next;  // Перемещаем указатель результата
        }
        // Если один из списков ещё не пуст — добавляем оставшиеся узлы
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Возвращаем голову реального списка (после заглушки)
        return dummy.next;
    }
}
