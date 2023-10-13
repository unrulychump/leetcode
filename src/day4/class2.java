package day4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * hard
 *给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 利用优先队列自动排序的特点完成题目
 * （主要还是利用了数据结构）
 *
 * 没精神了 明天再看 10-12
 */
public class class2 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                //如果index0的两个数不相等，返回p1-p2 如果相等返回index1上的p1-p2
                //就是按照第一个/第二个元素降序排列
                public int compare(int[] pair1, int[] pair2) {
                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                }
            });
            //offer 插入元素 peek 获得优先级最高的元素但是不出队 poll 将优先级最高的元素出队
            //写入的为value,index
            for (int i = 0; i < k; ++i) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                //如果，现有的最大值是新的滑动窗口没有的，那么删除(出队)
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }
}
