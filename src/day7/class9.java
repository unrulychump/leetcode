package day7;

import com.ibm.dtfj.phd.util.SortListener;

import java.util.*;

/**
 * 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */

/**
 * Arrays 主要用于操作原始数据类型数组（如 int[]、double[] 等）和对象数组。
 * Collections 主要用于操作对象集合，如 List、Set 和 Map，这些集合可以存储对象的引用。
 */
public class class9 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        //常规来说，使用一个List就可以完成的了，空间占用在On 时间复杂度在nlogn
        //但是进阶要求在 ：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
        public ListNode sortList(ListNode head) {
            //艹，怎么会有空链表啊不做人
            if(head==null){
                return head;
            }
            //先使用list做一遍题目
            List<ListNode> list=new ArrayList<>();
            ListNode node=head;
            while (node!=null){
                list.add(node);
                node=node.next;
            }
            //使用Arrays对node排序
            //不能使用Arrays 使用Collections
            //对于list使用Collections
            Collections.sort(list, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val-o2.val;
                }
            });
            //对排序玩的list重新编排
            ListNode cur=list.get(0);
            for(int i=1;i<list.size();i++){
                cur.next=list.get(i);
                //绷不住了，一遍没成功自己要debug好久
                cur=cur.next;
            }
            list.get(list.size()-1).next=null;
            return list.get(0);
        }
    }

    //gpt给出的符合题目要求的题解：
    class Solution_GPT {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // 找到链表的中点，分为两个子链表
            ListNode slow = head, fast = head, prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;

            // 递归地对两个子链表进行排序
            ListNode left = sortList(head);
            ListNode right = sortList(slow);

            // 合并两个有序链表
            return merge(left, right);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }

            if (l1 != null) {
                current.next = l1;
            }
            if (l2 != null) {
                current.next = l2;
            }

            return dummy.next;
        }
    }

}
