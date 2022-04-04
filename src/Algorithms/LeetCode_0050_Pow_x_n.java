package Algorithms;

public class LeetCode_0050_Pow_x_n {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(x == 0 || x == 1){
            return x;
        }

        if(n < 0){
            //为了避过-2147483648的测试用例越界（为了赚分的沙雕测试用例）
            return 1 / (x*myPow(x,-n - 1));
        }else{
            if((n & 1) == 0){
                return myPow(x * x, n >> 1);
            }else{
                return x * myPow(x * x, n >> 1) ;
            }
        }
    }
}
