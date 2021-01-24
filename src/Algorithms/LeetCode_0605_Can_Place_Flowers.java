package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/24/2021 22:58
 */
public class LeetCode_0605_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int index = 0;
        while (index < flowerbed.length){
            if (n <= 0){
                return true;
            }
            if (flowerbed[index] == 1){
                index += 2;
            }else if (index == flowerbed.length - 1 || flowerbed[index + 1] == 0){
                n--;
                index += 2;
            }else {
                index += 3;
            }
        }
        return n <= 0;
    }
}
