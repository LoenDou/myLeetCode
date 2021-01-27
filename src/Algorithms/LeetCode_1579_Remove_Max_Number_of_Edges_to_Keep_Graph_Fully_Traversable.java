package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/27/2021 21:51
 */
public class LeetCode_1579_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (n == 0 || edges == null || edges.length == 0){
            return 0;
        }

        //一个来处理A  一个来处理B
        UnionFind unionA = new UnionFind(n);
        UnionFind unionB = new UnionFind(n);
        int result = 0;

        //将节点序号从0开始，方便并查集操作
        for (int[] ele : edges) {
            ele[1]--;
            ele[2]--;
        }

        //先处理公共边
        for (int[] ele : edges) {
            if (ele[0] == 3){
                //如果两个点已经连通 需要删的边+1
                if (unionA.isConnected(ele[1],ele[2])){
                    result++;
                }else {
                    unionA.union(ele[1],ele[2]);
                    unionB.union(ele[1],ele[2]);
                }
            }
        }

        //处理A/B各自的边
        for (int[] ele : edges) {
            if (ele[0] == 1){
                if (unionA.isConnected(ele[1],ele[2])){
                    result++;
                }else {
                    unionA.union(ele[1],ele[2]);
                }
            }
            if (ele[0] == 2){
                if (unionB.isConnected(ele[1],ele[2])){
                    result++;
                }else {
                    unionB.union(ele[1],ele[2]);
                }
            }
        }

        //连通分量不为1时说明Alice 和 Bob 无法完全遍历图，则返回 -1
        if (unionA.getCount() != 1 || unionB.getCount() != 1){
            return -1;
        }
        return result;
    }

    private class UnionFind{
        private int[] parents;
        private int[] size;
        //连通分量
        private int count;

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
