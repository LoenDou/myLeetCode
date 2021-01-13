package Algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/14/2021 2:55
 */
public class LeetCode_0003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        while (left < s.length()){
            if (left != 0){
                set.remove(s.charAt(left - 1));
            }
            while (right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            result = Math.max(result,right - left);
            left++;
        }
        return result;
    }
}
