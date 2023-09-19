package day1;

import java.util.*;

/**
 * 字符串异位词分组：
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * hashMap
 */

//讲道理他们算时间复杂度都不算小粒度的排序的复杂度
public class class2 {
    class Solution {
        //排序后的字符串作为map的key
        public List<List<String>> groupAnagrams_1(String[] strs) {
            Map<String,List<String>> map=new HashMap<String, List<String>>();
            //对每个str排序，写入hashmap
            for(String str:strs){
                char[] arry=str.toCharArray();
                Arrays.sort(arry);
                String str1=new String(arry);
                List<String> list=map.getOrDefault(str1,new ArrayList<String>());
                list.add(str);
                /**
                 * map.getOrDefault(Object key,  Object defaultValues);
                 * 如果有，返回查找到的值，如果没有，返回defaultValue
                 * 因为写入到hashmap中的值是list类型的，所以不会产生类型冲突
                 */
                map.put(str1,list);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }


}
