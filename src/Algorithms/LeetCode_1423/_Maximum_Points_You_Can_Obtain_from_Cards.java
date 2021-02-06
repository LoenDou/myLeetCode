package Algorithms.LeetCode_1423;

import java.util.Arrays;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 2/7/2021 0:02
 */
public class _Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0 || k == 0){
            return 0;
        }

        //滑剩余数组的最小和
        int len = cardPoints.length - k;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += cardPoints[i];
        }
        min = sum;
        for (int i = len; i < cardPoints.length; i++) {
            sum = sum - cardPoints[i - len] + cardPoints[i];
            min = Math.min(min,sum);
        }

        return Arrays.stream(cardPoints).sum() - min;
    }
}
