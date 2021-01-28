package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/29/2021 2:57
 */
public class LeetCode_724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int leftCount = 0;
        for (int n :
                nums) {
            sum += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftCount == (sum - nums[i] -leftCount)){
                return i;
            }
            leftCount += nums[i];
        }
        return -1;
    }
}
