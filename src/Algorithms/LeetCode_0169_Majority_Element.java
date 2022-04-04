package Algorithms;

import java.util.HashMap;

public class LeetCode_0169_Majority_Element {
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > nums.length / 2) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }

    public int majorityElement2(int[] nums) {
        int num = 0;
        int count = 0;
        for (int i :
                nums) {
            if (count == 0) {
                num = i;
            }
            count += num == i ? 1 : -1;
        }
        return num;
    }
}
