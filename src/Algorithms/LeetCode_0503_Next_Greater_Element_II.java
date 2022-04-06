package Algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LeetCode_0503_Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int top = stack.poll();
                result[top] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}
