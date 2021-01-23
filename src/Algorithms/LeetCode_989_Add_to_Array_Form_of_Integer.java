package Algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/23/2021 21:42
 */
public class LeetCode_989_Add_to_Array_Form_of_Integer {
    public List<Integer> addToArrayForm(int[] A, int K) {
        if (A == null || A.length == 0){
            return new LinkedList<>();
        }

        List<Integer> result = new LinkedList<>();
        int sum = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            sum = A[i] + (K % 10);
            K /= 10;
            if (sum >= 10) {
                sum -= 10;
                K += 1;
            }
            result.add(0,sum);
        }
        for (; K > 0; K /= 10) {
            result.add(0,K % 10);
        }
        return result;
    }
}
