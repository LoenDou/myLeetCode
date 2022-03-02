package Algorithms;

import java.util.Arrays;

public class LeetCode_0976_Largest_Perimeter_Triangle {
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
