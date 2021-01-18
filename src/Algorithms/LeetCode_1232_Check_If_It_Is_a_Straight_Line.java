package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description 函数
 * @date 1/18/2021 14:06
 */
public class LeetCode_1232_Check_If_It_Is_a_Straight_Line {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length == 0) {
            return false;
        }

        //求斜率除法 (y3-y2)/(x3-x2)=(y2-y1)(x2-x1)  转换为乘法  (x2-x1)*(y3-y2)=(y2-y1)(x3-x2)
        int k_x = coordinates[1][0] - coordinates[0][0];
        int k_y = coordinates[1][1] - coordinates[0][1];

        for (int i = 1; i < coordinates.length; i++) {
            //防止重复计算
            int k_xi = coordinates[i][0] - coordinates[0][0];
            int k_yi = coordinates[i][1] - coordinates[0][1];
            if (k_x * k_yi != k_xi * k_y){
                return false;
            }
        }
        return true;
    }
}
