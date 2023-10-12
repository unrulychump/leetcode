package day5;

import java.util.HashMap;

/**
 * 缺失的第一个正数(hard)
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * md 题目看错了，看成没有出现在连续数组中的数。。。。。。。。
 */
public class class5 {
    int value;
    public boolean ScanMap1(HashMap<Integer,Float> map,int index0){
        //如果当前的值是存在的
        if(map.getOrDefault(index0,0.12f)!=0.12f){
            ScanMap1(map,index0+1);
        }
        else{
            //现在的index不存在，但是下一个存在，说明在这里断开了
            if(map.getOrDefault(index0+1,0.12f)!=0.12f){
                value=index0;
                return true;
            }
            else
                //如果下一个也不存在说明是数组到头了
                return false;
        }
        return false;
    }
    public boolean ScanMap2(HashMap<Integer,Float> map,int index0){
        //如果当前的值是存在的
        if(map.getOrDefault(index0,0.12f)!=0.12f){
            ScanMap1(map,index0-1);
        }
        else{
            //现在的index不存在，但是下一个存在，说明在这里断开了
            if(map.getOrDefault(index0-1,0.12f)!=0.12f){
                value=index0;
                return true;
            }
            else
                //如果下一个也不存在说明是数组到头了
                return false;
        }
        return false;
    }
    public int firstMissingPositive(int[] nums) {
        //index,value
        int index0=nums[0];
        HashMap<Integer,Float> map=new HashMap<>();
        for(int x:nums){
            map.put(x, (float) x);
        }
        int indexL,indexR;
        while(true) {
            if (ScanMap1(map, index0))
                return value;
            if (ScanMap2(map, index0))
                return value;
            break;
        }
        return value;
    }



    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            for (int i = 0; i < n; ++i) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            for (int i = 0; i < n; ++i) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }
}
