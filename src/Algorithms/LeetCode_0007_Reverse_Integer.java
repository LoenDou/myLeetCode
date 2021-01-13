package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/14/2021 2:56
 */
public class LeetCode_0007_Reverse_Integer {
    public int reverse(int x) {
        long n = 0;
        while(x!=0){
            n = x%10 + n*10;
            x/=10;
        }
        if(n>Integer.MAX_VALUE || n<Integer.MIN_VALUE){
            return 0;
        }
        return (int)n;
    }
}
