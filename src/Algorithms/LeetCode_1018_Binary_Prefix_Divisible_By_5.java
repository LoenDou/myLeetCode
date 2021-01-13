package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dou
 * @version 1.0
 * @description LeetCode-1018
 * @date 1/14/2021 1:40
 */
public class LeetCode_1018_Binary_Prefix_Divisible_By_5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<>();
        }

        //只保留余数即可
        List<Boolean> list = new ArrayList<>();
        int tempRes = 0;
        for (int i = 0; i < A.length; i++) {
            tempRes = (tempRes << 1) + A[i];
            tempRes %= 5;
            list.add(tempRes==0);
        }
        return list;
    }
}
