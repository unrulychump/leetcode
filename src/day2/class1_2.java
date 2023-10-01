package day2;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 双指针， 困难题
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class class1_2 {
    class Solution {

        //逆天leetcode 搞这么多循环的case 现在过不了了
        public int trap_1(int[] height) {
            int sum = 0;
            int max = getMax(height);//找到最大的高度，以便遍历。
            for (int i = 1; i <= max; i++) {
                boolean isStart = false; //标记是否开始更新 temp
                int temp_sum = 0;
                for (int j = 0; j < height.length; j++) {
                    if (isStart && height[j] < i) {
                        temp_sum++;
                    }
                    if (height[j] >= i) {
                        sum = sum + temp_sum;
                        temp_sum = 0;
                        isStart = true;
                    }
                }
            }
            return sum;
        }

//        public int trap(int[] height){
//
//        }

        private int getMax(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > max) {
                    max = height[i];
                }
            }
            return max;
        }
    }
}
