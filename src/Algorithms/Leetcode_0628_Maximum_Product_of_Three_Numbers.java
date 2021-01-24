package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/20/2021 12:17
 */
public class Leetcode_0628_Maximum_Product_of_Three_Numbers {
    public static int maximumProduct(int[] nums) {
        //全为正或者全为负的时候 三个最大数相乘乘积为最大数
        //有正有负时 两个最小的数与最大数的乘积为最大数
        int max_1 = Integer.MIN_VALUE;
        int max_2 = Integer.MIN_VALUE;
        int max_3 = Integer.MIN_VALUE;
        int min_1 = Integer.MAX_VALUE;
        int min_2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max_1) {
                max_3 = max_2;
                max_2 = max_1;
                max_1 = n;
            }else if (n > max_2){
                max_3 = max_2;
                max_2 = n;
            }else if (n > max_3){
                max_3 = n;
            }

            if (n < min_1){
                min_2 = min_1;
                min_1 = n;
            }else if (n < min_2){
                min_2 = n;
            }
        }
        return Math.max(max_1 * max_2 * max_3,max_1 * min_1 * min_2);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(maximumProduct(arr));
    }
}
