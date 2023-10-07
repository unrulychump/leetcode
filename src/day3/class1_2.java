package day3;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 前缀+hash
 * 前缀是计算一直加到该项的数字和
 */
public class class1_2 {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int[] countNums=new int[nums.length];
        if(nums.length==1){
            if(nums[0]==k){
                return 1;
            }
            else
                return 0;
        }
        countNums[0]=nums[0];
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=1;i<nums.length;i++){
            countNums[i]+=nums[i];
            if(map.containsKey(countNums[i]-k)){
                //这样的结果可能存在不止一组
                count+=map.get(countNums[i]-k);
            }
            map.put(countNums[i],map.getOrDefault(countNums[i],0));
        }
        return  count;
    }

    public static void main(String[] args) {

    }
}
