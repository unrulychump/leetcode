package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 字符串专题
 * 双指针问题保证O(n)复杂的
 * 滑动窗口问题
 */
public class class1_1 {
    static class Solution {

        //方法1滑动窗口
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list=new ArrayList<>();
            int[] count_p=new int[26];
            int length=p.length();
            for(int i=0;i<p.length();i++){
                count_p[p.charAt(i)-'a']+=1;
            }
            String countStr_p= Arrays.toString(count_p);
            //System.out.println(countStr_p);
            for(int i=0;i<=s.length()-p.length();i++){
                int[] count=new int[26];
                for(int j=i;j<i+length;j++){
                    count[s.charAt(j)-'a']+=1;
                }
                String countStr_s=Arrays.toString(count);
                if(countStr_s.equals(countStr_p)){
                    list.add(i);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd","abc"));
    }
}
