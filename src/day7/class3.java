package day7;

import java.util.List;

/**
 * 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 */
public class class3 {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class  Solution{
        ListNode reverseList(ListNode head){
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
        public boolean isPalindrome(ListNode head) {
            //利用上一题的结果，先将链表反转，再将链表进行对比
            ListNode reListNode=reverseList(head);
            while(head.next!=null || reListNode.next!=null){
                System.out.println("head.val  "+head.val);
                System.out.println("reListNode.val  "+reListNode.val);
                if(head.val!=reListNode.val)
                    return false;
                head=head.next;
                reListNode=reListNode.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ListNode listNode= new ListNode(1);
        ListNode listNode1= new ListNode(2, listNode);
        ListNode listNode2= new ListNode(2, listNode1);
        ListNode listNode3= new ListNode(1, listNode2);
        Solution solution=new Solution();
        solution.isPalindrome(listNode);
        System.out.println("111");
    }
}
