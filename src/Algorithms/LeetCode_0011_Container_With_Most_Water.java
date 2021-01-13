package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/14/2021 3:01
 */
public class LeetCode_0011_Container_With_Most_Water {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int curArea = 0;
        while (left <= right){
            curArea = (right - left) * Math.min(height[left],height[right]);
            max = Math.max(max,curArea);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
