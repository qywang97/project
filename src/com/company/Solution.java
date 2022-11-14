package com.company;



/*class Solution {
9\7\2\5\4\3\6
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;// 5
            cur.next = next.next; // cur 4
            next.next = pre.next; // 2
            pre.next = next;//9 7 5 2 4 3 6
        }
        return dummyNode.next;
    }
}

 */

