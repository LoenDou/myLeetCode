package Algorithms;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/24/2021 22:57
 */
public class LeetCode_0239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //单调队列
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] maxArr = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //形成完整滑动窗口前
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]){
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
        }
        maxArr[0] = deque.getFirst();
        //形成完整滑动窗口后
        for (int i = k; i < nums.length; i++) {
            if (deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            maxArr[i - k + 1] = deque.getFirst();
        }

        return maxArr;
    }
}
