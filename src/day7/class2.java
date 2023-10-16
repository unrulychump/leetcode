package day7;

import java.util.ArrayList;
import java.util.List;

/**
 *给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class class2 {
     class ListNode {
      int val;
      ListNode next;ListNode() {}
        ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
    //太猛了，直接把next指向上一个，改一下方向就ok了
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
