package day5;

/**
 * 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i]
 * 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题
 */
public class class4 {
    public int[] productExceptSelf(int[] nums) {
        //使用类似前缀和的方式解决问题
        int[] mtL=new int[nums.length];
        int[] mtR=new int[nums.length];
        int[] res=new int[nums.length];
        mtL[0]=1;mtR[0]=1;
        for(int i=1;i<nums.length;i++){
            mtL[i]=nums[i-1]*mtL[i-1];
            mtR[i]=nums[mtL.length-i]*mtR[i-1];
        }
        for (int i=0;i< mtL.length;i++){
            res[i]=mtR[mtL.length-1-i]*mtL[i];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
