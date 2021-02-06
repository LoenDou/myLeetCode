package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 2/7/2021 3:59
 */
public class LeetCode_0665_Non_decreasing_Array {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return true;
        }

        boolean bool = nums[1] >= nums[0] ? true : false;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                //操作前一个数可能会破坏之前的满足条件
                //操作i或者i+1 如果后一个数比前一个数大，可以将i变成后一个数 如：3 6 4 -> 3 4 4
                //如果后一个数比前一个数小，只能改变后一个数为当前数 如： 3 6 2 -> 3 6 6
                if (bool){
                    if (nums[i + 1] >= nums[ i - 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                    bool = false;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
