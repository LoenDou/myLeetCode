package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/24/2021 22:52
 */
public class LeetCode_0830_Positions_of_Large_Groups {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || s.length() == 1) {
            return new ArrayList();
        }
        int first = 1;
        int second = 0;
        int count = 1;
        List<List<Integer>> lists = new ArrayList<>();
        while (first < s.length()){
            while (first < s.length() && s.charAt(first) == s.charAt(second)){
                count++;
                first++;
            }
            if (count >= 3){
                List<Integer> ele = new ArrayList<>();
                ele.add(second);
                ele.add(first - 1);
                lists.add(ele);
            }
            count = 1;
            second = first;
            first++;
        }
        return lists;
    }
}
