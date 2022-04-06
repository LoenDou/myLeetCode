package Algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class LeetCode_0496_Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int top = stack.pop();
                map.put(nums2[top], nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                result[i] = map.get(nums1[i]);
            }
        }
        return result;
    }
}
