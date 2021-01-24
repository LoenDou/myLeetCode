package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description 并查集
 * @date 1/24/2021 22:49
 */
public class LeetCode_0547_Number_of_Provinces {
    private void union(int[] parents,int index_1,int index_2){
        parents[finRoot(parents,index_1)] = finRoot(parents,index_2);
    }

    private int finRoot(int[] parents,int index){
        while (parents[index] != index){
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }
    public int findCircleNum(int[][] isConnected) {
        int[] parents = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            parents[i] = i;
        }
        for(int i = 0;i < isConnected.length;i++){
            for(int j = i + 1;j < isConnected.length;j++){
                if(isConnected[i][j] == 1){
                    union(parents,i,j);
                }
            }
        }
        for(int i = 0;i < parents.length;i++){
            if(parents[i] == i){
                count++;
            }
        }
        return count;
    }
}
