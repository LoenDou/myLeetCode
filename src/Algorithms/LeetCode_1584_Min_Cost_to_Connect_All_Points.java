package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dou
 * @version 1.0
 * @description 最小生成树 Kruskal(并查集)
 * @date 1/19/2021 16:30
 */

//边
class Edge{
    //表示两个点索引  边权值
    int a,b,val;

    public Edge(int a, int b, int val) {
        this.a = a;
        this.b = b;
        this.val = val;
    }
}

public class LeetCode_1584_Min_Cost_to_Connect_All_Points {
    private static void union(int[] parents,int[] rank,int index1,int index2){
        int pRoot = find(parents,index1);
        int qRoot = find(parents,index2);
        if (pRoot == qRoot){
            return;
        }
        if (rank[pRoot] < rank[qRoot]){
            parents[pRoot] = qRoot;
        }else if (rank[qRoot] < rank[pRoot]){
            parents[qRoot] = pRoot;
        }else {// ==
            //相等随意合并  合并后高度加1
            parents[pRoot] = qRoot;
            rank[pRoot] += 1;
        }
    }

    private static int find(int[] parents,int index){
        while (parents[index] != index) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public static int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return -1;
        }

        int[] parents = new int[points.length];
        int[] rank = new int[points.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        //构建点与点之间边的权值集合
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edgeList.add(new Edge(i,j,Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }

        //边权值排序
        Collections.sort(edgeList,((o1, o2) -> o1.val - o2.val));

        int result = 0;
        //n个点只需要n-1条边即可跳出循环
        int count = 0;
        for (Edge e : edgeList) {
            if (count == points.length - 1){
                break;
            }
            if (find(parents,e.a) != find(parents,e.b)){
                union(parents,rank,e.a,e.b);
                result += e.val;
                count++;
            }
        }

        return result;
    }
}
