package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/31/2021 2:48
 */
public class LeetCode_0839_Similar_String_Groups {
    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }

        int n = strs.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (unionFind.isConnected(i,j)){
                    continue;
                }
                if (checkSimilarWord(strs[i],strs[j])){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.getCount();
    }

    //检查两个单词是否相似
    public boolean checkSimilarWord(String word1,String word2){
        if(word1.equals(word2)){
            return true;
        }
        int count = 0;
        //如果说两个单词的不同之处大于2，那么就无法通过一次交换变成相同单词
        //换句话说，大于二则不相似
        for(int i = 0;i < word1.length();i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
                if(count>2){
                    return false;
                }
            }
        }
        return true;
    }

    //并查集模板
    class UnionFind{
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
