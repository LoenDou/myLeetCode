package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/24/2021 22:48
 */
public class LeetCode_0189_Rotate_Array {
    private void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        //先整体翻转  再翻转前k  最后翻转k之后
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
}
