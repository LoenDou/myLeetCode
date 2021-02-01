package Algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 2/1/2021 22:39
 */
public class LeetCode_0888_Fair_Candy_Swap {
    public int[] fairCandySwap(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0){
            return new int[0];
        }

        // sumA + x - y = sumB + y - x;   x = (sumB - sumA)/2 + y;
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int gap = (sumA - sumB) / 2;

        //随便返回一组即可 所以用set
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }

        for (int num : B) {
            if (set.contains(num + gap)){
                return new int[]{num + gap,num};
            }
        }
        return new int[0];
    }
}
