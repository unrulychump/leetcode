package day1;

import java.util.HashMap;
import java.util.Map;

/**hash 题目1：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 两数之和
 * */

public class class1 {
    class Solution {
        //方案一，暴力双循环
        public int[] twoSum_1(int[] nums, int target) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }

        //方案二 使用hash表解决
        public int[] twoSum_2(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];

        }
    }
}
/**
 *
 * 方案二解释：
 * map的写入是 num[i],i    key写入的是num[i]的值 value写入的是index
 * 如果有key的值相加等于target的就成功了
 * 使用hash表的愿意是存在重复存在的数值对
 */