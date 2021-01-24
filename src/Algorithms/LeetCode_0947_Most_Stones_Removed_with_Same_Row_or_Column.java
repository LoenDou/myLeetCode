package Algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dou
 * @version 1.0
 * @description 并查集
 * @date 1/15/2021 2:06
 */
public class LeetCode_0947_Most_Stones_Removed_with_Same_Row_or_Column {
    private static void union(int[] parents,int index1,int index2){
        int pRoot = find(parents,index1);
        int qRoot = find(parents,index2);
        if (pRoot == qRoot) {
            return;
        }
        parents[pRoot] = qRoot;
    }

    private static int find(int[] parents,int index){
        while (parents[index] != index){
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public static int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        int[] parents = new int[20000];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < stones.length; i++) {
            //区别横纵坐标
            union(parents,stones[i][0],stones[i][1] + 10000);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            set.add(find(parents,stones[i][0]));
        }

        return stones.length - set.size();
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int[][] arr1 = {{0,0},{0,2},{1,1},{2,0},{2,2}};
        int[][] arr2 = {{0,0}};
        System.out.println(removeStones(arr));
    }
}
