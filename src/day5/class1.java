package day5;
//普通数组题目

/**
 * 最大子数和（middle）
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
 * （子数组最少包含一个元素），
 * 返回其最大和。
 * 动态规划
 * O(n)的解决方法是什么
 * 分治法
 */
public class class1 {
    class Solution {
        //使用动态规划解决问题
        //转移方程1：dp[i]=max{nums[i],dp[i−1]+nums[i]}
        //滚动变量的方式优化
        public int maxSubArray(int[] nums) {
            int len=nums.length;
            //dp变量表示的是以nums[i]结尾的数组的最大子数和
            int[] dp=new int[len];
            dp[0]=nums[0];
            for(int i=1;i<len;i++){
                if(dp[i-1]>0){
                    dp[i]=dp[i-1]+nums[i];
                }
                else
                    dp[i]=nums[i];
            }
            int res=dp[0];
            for(int i=0;i<len;i++){
                res=Math.max(dp[i],res);
            }
            return res;

        }
    }
}
