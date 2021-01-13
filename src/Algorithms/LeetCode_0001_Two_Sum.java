package Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/14/2021 2:48
 */
public class LeetCode_0001_Two_Sum {
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            int discre = target-nums[i];
            if(map.containsKey(discre)){
                return new int[] {i,map.get(discre)};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
