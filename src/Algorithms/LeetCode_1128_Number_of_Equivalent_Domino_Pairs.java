package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/27/2021 18:25
 */
public class LeetCode_1128_Number_of_Equivalent_Domino_Pairs {
    //使用数组的方式
    public int numEquivDominoPairs1(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0) {
            return 0;
        }
        //因为1 <= dominoes[i][j] <= 9  最大为99  所以用数组代替哈希表
        int[] nums = new int[100];
        int count = 0;
        for (int[] ele : dominoes) {
            int tmp = 0;
            //将最小数放在前面 如：1,3 13 | 3,1 13
            if (ele[0] > ele[1]){
                tmp = ele[1] * 10 + ele[0];
            }else {
                tmp = ele[0] * 10 + ele[1];
            }
            count += nums[tmp];
            nums[tmp]++;
        }
        return count;
    }

   /* //使用hash表的方式
    public int numEquivDominoPairs2(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0) {
            return 0;
        }

    }

    //重写了equal与hashcode的类
    private class overrideHash{
        private int key;
        private int value;

        public overrideHash(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
           if (o == this){
               return true;
           }
           if (o == null || o.getClass() != getClass()){
               return false;
           }
           overrideHash that = (overrideHash) o;
           return (key == that.key && value == that.value) || (key == that.value && value == that.key);
        }

        @Override
        public int hashCode() {
            if (key > value){
                return value * 10 + key;
            }
            return key * 10 + value;
        }
    }*/
}
