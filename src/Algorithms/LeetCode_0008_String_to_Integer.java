package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/14/2021 2:58
 */
public class LeetCode_0008_String_to_Integer {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int index = 0;
        int isNegative = 1;
        int result = 0;
        int boundary = Integer.MAX_VALUE / 10;
        if(chars[0] == '-' ){
            index++;
            isNegative = -1;
        }else if(chars[0] == '+'){
            index++;
        }
        for (; index < chars.length; index++) {
            if (chars[index] < '0' || chars[index] > '9') {
                break;
            }
            if (result > boundary || result == boundary && chars[index] > '7'){
                if (isNegative == -1) {
                    return Integer.MIN_VALUE;
                }else {
                    return Integer.MAX_VALUE;
                }
            }
            result = result * 10 + (chars[index] - '0');
        }

        return result * isNegative;
    }
}
