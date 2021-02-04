package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 2/4/2021 23:04
 */
public class LeetCode_0643_Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0){
            return 0;
        }

        double max = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(max,sum);
        }
        return max / k;
    }
}
