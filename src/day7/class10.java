package day7;

import com.ibm.dtfj.corereaders.zos.mvs.Lse;

import java.util.*;

/**
 * 合并 K 个升序链表(hard)
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class class10 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        class Solution {
        //如果我使用上一题的解法会怎么样？我试试看
        public ListNode mergeKLists_1(ListNode[] lists) {
            //如果我使用上一题的解法会怎么样？我试试看
            if(lists.length==0){
                return null;
            }
            List<ListNode> listArray=new ArrayList<>();
            for(int i=0;i<lists.length;i++){
                ListNode node=lists[i];
                while (node!=null){
                    listArray.add(node);
                    node=node.next;
                }
            }
            if(listArray.size()==0){
                return null;
            }
            Collections.sort(listArray, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val-o2.val;
                }
            });
            ListNode cur=listArray.get(0);
            for(int i=1;i<listArray.size();i++){
                cur.next=listArray.get(i);
                //绷不住了，一遍没成功自己要debug好久
                cur=cur.next;
            }
            listArray.get(listArray.size()-1).next=null;
            return listArray.get(0);
        }
    }
}
