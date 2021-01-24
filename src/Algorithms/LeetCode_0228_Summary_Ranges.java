package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/24/2021 22:47
 */
public class LeetCode_0228_Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        if (nums.length == 1){
            list.add(String.valueOf(nums[0]));
            return list;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            slow = fast++;
            while (fast < nums.length && nums[fast] - nums[fast - 1] == 1){
                fast++;
            }
            if (slow < fast - 1){
                list.add(nums[slow] + "->" + nums[fast - 1]);
            }else {
                list.add(String.valueOf(nums[slow]));
            }
        }
        return list;
    }
}
