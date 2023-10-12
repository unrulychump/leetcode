package day5;

import java.util.HashMap;
import java.util.Map;

/**
 * 轮转数组(middle)
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 */
public class class3 {
    public static void rotate(int[] nums, int k) {
        //从1开始数
        int size=nums.length;
        k=k%size;
        //怎么可能有O(1)的算法。。。。
        int[] nums1=new int[size];
        for(int i=0;i< size;i++){
            nums1[(i+k)%size]=nums[i];
        }
        int i=0;
        for (int x:nums1){
            nums[i]=x;
            i++;
        }
    }
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5},2);
    }
}
