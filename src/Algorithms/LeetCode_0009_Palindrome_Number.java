package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/14/2021 3:00
 */
public class LeetCode_0009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int reverse = 0;
        //取后半段的数
        //反转的数  大于  x 即一半或一半多一位
        while (reverse < x) {
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }
        if (x == reverse || x == reverse / 10){
            return true;
        }
        return false;
    }
}
