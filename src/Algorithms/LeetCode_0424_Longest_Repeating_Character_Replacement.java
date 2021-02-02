package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description 双指针 滑动窗口
 * @date 2/2/2021 23:42
 */
public class LeetCode_0424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        if (n < 2){
            return n;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        //记录各字母长度
        int[] alphaNums = new int[26];

        while (right < n){
            alphaNums[chars[right] - 'A']++;
            max = Math.max(max,alphaNums[chars[right] - 'A']);
            //总个数-最多的字母的个数 > k
            if (right - left + 1 - max > k){
                alphaNums[chars[left] - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
