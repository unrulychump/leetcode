package day4;

import java.util.HashMap;

/**
 * 最小覆盖子串(hard)
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class class3 {
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            int[] arr = new int['z' - 'A' + 1];
            for (char c : t.toCharArray()) {
                arr[c - 'A']++;
            }
            int cnt = t.length();
            int begin = -1;
            int count = s.length() + 1;
            char[] chars = s.toCharArray();
            int l = 0;
            int r = 0;
            while (r < s.length()) {
                if (arr[chars[r++] - 'A']-- > 0) {
                    cnt--;
                }
                if (cnt == 0) {
                    while (arr[chars[l] - 'A']++ < 0) {
                        l++;
                    }
                    if (count > r - l) {
                        begin = l;
                        count = r - l;
                    }
                    l++;
                    cnt++;
                }
            }
            return begin == -1 ? "" : new String(chars, begin, count);
        }
    }
}
