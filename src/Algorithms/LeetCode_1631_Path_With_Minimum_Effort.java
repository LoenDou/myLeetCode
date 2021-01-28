package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dou
 * @version 1.0
 * @description 能用并查集 类似Krusk 但不考虑环
 * @date 1/29/2021 2:58
 */
public class LeetCode_1631_Path_With_Minimum_Effort {
    public static int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return -1;
        }

        int m = heights.length;
        int n = heights[0].length;

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //将m * n的二维矩阵转换为一维的索引index
                int index = i * n + j;
                //计算该节点与上一行相同列的节点的权值
                if (i > 0){
                    edges.add(new Edge(index - n,index,Math.abs(heights[i][j] - heights[i - 1][j])));
                }
                //计算该节点与同一行上一列的节点的权值
                if (j > 0){
                    edges.add(new Edge(index - 1,index,Math.abs(heights[i][j] - heights[i][j - 1])));
                }
            }
        }
        //按权值进行排序
        Collections.sort(edges,(o1, o2) -> o1.weight - o2.weight);

        UnionFind unionFind = new UnionFind(m * n);
        int result = 0;
        for (Edge edge : edges) {
            unionFind.union(edge.x,edge.y);
            //左上和右下连通时  此时权值为最小的体力消耗
            if (unionFind.isConnected(0,m * n - 1)){
                result = edge.weight;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(arr));
    }

    static class Edge{
        //表示两个点索引  边权值
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    //并查集模板
    static class UnionFind{
        int[] parents;
        int[] size;
        //连通分量
        int count;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.size = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public void union(int index1,int index2){
            int pRoot = find(index1);
            int qRoot = find(index2);
            if (pRoot == qRoot) {
                return;
            }
            if (size[pRoot] < size[qRoot]){
                parents[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }else {
                parents[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
            count--;
        }

        //size优化
        public int find(int index){
            while (parents[index] != index){
                parents[index] = parents[parents[index]];
                index = parents[index];
            }
            return index;
        }

        public int getCount(){
            return count;
        }

        //是否连通
        public boolean isConnected(int index1,int index2){
            return find(index1) == find(index2);
        }
    }
}
