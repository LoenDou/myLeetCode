package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/24/2021 22:53
 */
public class LeetCode_0509_Fibonacci_Number {
    public int fib(int n) {
        int[] res = {0,1};
        if (n < 2){
            return res[n];
        }
        int fib = 0;
        int fibOne = 0;
        int fibTwo = 1;
        for(int i = 2;i <= n;i++){
            fib = fibOne + fibTwo;
            fibOne = fibTwo;
            fibTwo = fib;
        }
        return fib;
    }
}
