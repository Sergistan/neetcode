package com.utochkin.LinkedList;

// Merge K Sorted Linked Lists
public class ListNode7 {

    private int val;
    private ListNode7 next;

    ListNode7(int val) {
        this.val = val;
    }

    ListNode7() {
    }

    ListNode7(int val, ListNode7 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode7{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        ListNode7 two1 = new ListNode7(4);
        ListNode7 one1 = new ListNode7(2, two1);
        ListNode7 head1 = new ListNode7(1, one1);
        // 1 → 2 → 4 → null

        ListNode7 two2 = new ListNode7(5);
        ListNode7 one2 = new ListNode7(3, two2);
        ListNode7 head2 = new ListNode7(1, one2);
        // 1 → 3 → 5 → null

        ListNode7 one3 = new ListNode7(6);
        ListNode7 head3 = new ListNode7(3, one3);
        // 3 → 6 → null

        ListNode7[] lists = new ListNode7[]{head1, head2, head3};

        System.out.println(mergeKLists(lists));
        // 1 → 1 → 2 → 3 → 3 → 4 → 5 → 6→ null
    }

    public static ListNode7 mergeKLists(ListNode7[] lists) {

        if (lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++) {
            lists[i] = merge(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];

    }

    public static ListNode7 merge(ListNode7 list1, ListNode7 list2) {

        ListNode7 dummy = new ListNode7();
        ListNode7 current = dummy;

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