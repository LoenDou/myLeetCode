package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description 双指针
 * @date 1/24/2021 22:38
 */
public class LeetCode_0674_Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 1;
        int count = 1;
        while (right < nums.length){
            if (nums[right] <= nums[right - 1]){
                left = right;
            }
            right++;
            count = Math.max(count,right - left);
        }
        return count;
    }
}
