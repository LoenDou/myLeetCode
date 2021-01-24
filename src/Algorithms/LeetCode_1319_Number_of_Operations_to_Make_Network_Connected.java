package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description 并查集
 * @date 1/24/2021 22:40
 */
public class LeetCode_1319_Number_of_Operations_to_Make_Network_Connected {
    int count;
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        this.count = n;
        int[] parents = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for (int[] ele : connections) {
            union(parents,size,ele[0],ele[1]);
        }
        return count - 1;
    }

    //按size秩构建并查集
    private void union(int[] parents,int[] size,int index1,int index2){
        int pRoot = find(parents,index1);
        int qRoot = find(parents,index2);
        if (pRoot == qRoot){
            return;
        }
        if (size[pRoot] < size[qRoot]){
            parents[pRoot] = qRoot;
        }else if (size[qRoot] < size[pRoot]){
            parents[qRoot] = pRoot;
        }else {// ==
            //相等随意合并  合并后高度加1
            parents[pRoot] = qRoot;
            size[pRoot] += 1;
        }
        count--;;
    }

    //路径压缩 - 隔代
    private int find(int[] parents,int index){
        while (parents[index] != index){
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }
}
