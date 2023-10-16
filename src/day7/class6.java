package day7;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class class6 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list2==null&&list1==null){
                return null;
            }
            if(list2!=null&&list1==null){
                return list2;
            }
            if(list2==null&&list1!=null){
                return list1;
            }
            return mergeTwoLists2(list1,list2);
        }
        public  ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            ListNode pre=list2;
            ListNode next=list2.next;

            ListNode tem=null;
            ListNode head=null;
            while (list1!=null){
                if(list1.val<= pre.val){
                    // 前
                    ListNode l1next=list1.next;
                    if(head==null){
                        list1.next=pre;
                        head=list1;
                        tem=list1;

                    }else {
                        list1.next=pre;
                        tem.next=list1;
                        tem=list1;
                    }
                    list1=l1next;

                }else if(list1.val> pre.val&&next!=null&&list1.val<= next.val){
                    ListNode l1next=list1.next;
                    // 中

                    if(head==null){
                        head=pre;
                    }
                    pre.next=list1;
                    list1.next=next;
                    tem=list1;
                    pre=next;
                    if(next!=null){
                        next=next.next;
                    }

                    list1=l1next;
                }else if (next==null){
                    ListNode l1next=list1.next;
                    // 后
                    if(head==null){
                        head=pre;
                    }
                    pre.next=list1;

                    break;
                }else {
                    if(head==null){
                        head=pre;
                    }
                    pre=next;
                    if(next!=null){
                        next=next.next;
                    }
                }
            }
            if (head==null){
                return list2;
            }else {
                return head;
            }
        }
    }
}
