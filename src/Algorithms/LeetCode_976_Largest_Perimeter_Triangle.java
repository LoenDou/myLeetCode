package Algorithms;

import java.util.Arrays;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 3/2/2022 21:55
 */
public class LeetCode_976_Largest_Perimeter_Triangle {
    public int largestPerimeter(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2 ; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]){
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
