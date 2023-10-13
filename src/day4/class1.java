package day4;

import java.util.HashMap;

/**
 * 字串问题合集
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */
//前缀和hash结合的问题
public class class1 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            //声明前缀和数组和hash表
            int pre=0;
            int count=0;
            //hashMap 第一个 pre的值(key)，第二个是前面出现pre的次数的值(value)
            HashMap<Integer,Integer> hashMap=new HashMap<>();
            hashMap.put(0,1);
            for(int i=0;i<nums.length;i++){
                pre+=nums[i];
                if(hashMap.containsKey(pre-k)){
                    count+=hashMap.get(pre-k);
                }
                hashMap.put(pre,hashMap.getOrDefault(pre,0)+1);
            }
            return count;
        }
    }
}
