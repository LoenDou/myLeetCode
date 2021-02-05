package Algorithms.LeetCode_1208;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 2/5/2021 23:07
 */
public class _Get_Equal_Substrings_Within_Budget {
    public int equalSubstring(String s, String t, int maxCost) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return 0;
        }

        int result = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        //将差值存在数组中
        int[] gap = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            gap[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        //双指针计算差值数组的和 小于maxCost
        while (right < s.length()){
            sum += gap[right];
            while (sum > maxCost){
                sum -= gap[left];
                left++;
            }
            right++;
            result = Math.max(result,right - left);
        }

        return result;
    }
}
