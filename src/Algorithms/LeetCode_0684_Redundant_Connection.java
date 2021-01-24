package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description 并查集
 * @date 1/24/2021 22:44
 */
public class LeetCode_0684_Redundant_Connection {
    private void union(int[] parents,int index1,int index2){
        parents[find(parents,index1)] = find(parents,index2);
    }

    private int find(int[] parents,int index){
        while (parents[index] != index){
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0){
            return new int[0];
        }

        int[] parents = new int[edges.length + 1];
        for (int i = 1; i < edges.length + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] ele = edges[i];
            if (find(parents,ele[0]) == find(parents,ele[1])){
                return ele;
            }else {
                union(parents,ele[0],ele[1]);
            }
        }
        return new int[0];
    }
}
