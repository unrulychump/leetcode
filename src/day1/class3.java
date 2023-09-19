package day1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长连续字符串
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class class3 {
    class Solution {
        //巧妙利用hashSet数据结构
        //使用set的取巧的方式真的不算时间复杂度的嘛
        public int longestConsecutive(int[] nums) {
            Set<Integer> set=new HashSet<Integer>();
            for(int i:nums){
                set.add(i);
            }
            int longest=0;
            for(int i:nums){
                if(!set.contains(i-1)){
                    int numX=i;
                    int length=1;
                    while (set.contains(numX+1)){
                        numX++;
                        length++;
                    }
                    longest= Math.max(longest,length);
                }
            }
            return longest;
        }
    }

}
