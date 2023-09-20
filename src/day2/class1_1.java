package day2;

/**
 * 双指针类型的题目
 * 好像有两道题目我已经做过了
 *移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class class1_1 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int index_0,index_x,count_0=0;
            for(int i:nums){
                if(i==0){
                    count_0+=1;
                }
            }
            while(count_0>=1){
                index_0=0;
                for(index_x=0;index_x<nums.length;index_x++){
                    if(nums[index_x]==0){
                        index_0=index_x;
                    }
                    else if (nums[index_x]!=0) {
                        int tmp=nums[index_x];
                        nums[index_x]=0;
                        nums[index_0]=tmp;
                        index_0=index_x;
                    }
                }
                System.out.println("index_0 :"+index_x);
                for(int i :nums){
                    System.out.print(i+",");
                }
                count_0-=1;
            }
        }

        public void main(String[] args) {
            Solution solution=new Solution();
            int[] nums =new int[]{0,1,1,0};
            solution.moveZeroes(nums);

        }
    }
    
}
