package day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 环形链表
 * 你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置
 * （索引从 0 开始）。注意：pos 不作为参数进行传递 。
 * 仅仅是为了标识链表的实际情况。
 */
public class class4 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
     static class Solution {
        public boolean hasCycle(ListNode head) {
            //艹 还真行 ListNode是空间位置 pos是链表上的位置
            //艹 hash会出现冲突的情况
            Map<ListNode,Integer> map=new HashMap<>();
            int pos=0;
            while(head!=null){
                if(map.get(head)==null){
                    map.put(head,pos);
                    pos+=1;
                    head=head.next;
                }
                else {
                    return true;
                }
            }
            return false;
        }
    }
}
