package Algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Dou
 * @version 1.0
 * @description LetCode-1202  交换字符串中的元素 - 并查集 Rank
 * @date 1/11/2021 22:24
 */
public class LeetCode_1202_Smallest_String_With_Swaps {

    //按rank秩构建并查集
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

    //路径压缩 - 隔代
    private static int find(int[] parents,int index){
        while (parents[index] != index){
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }

        int[] parents = new int[s.length()];
        int[] rank = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            parents[i] = i;
            rank[i] = 1;
        }
        //联通节点构建并查集
        for (List<Integer> pair :
                pairs) {
            union(parents, rank, pair.get(0), pair.get(1));
        }
        char[] chars = s.toCharArray();
        //构建与字母映射关系
        Map<Integer,PriorityQueue<Character>> map = new HashMap<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            int root = find(parents,i);
            if (!map.containsKey(root)){
                PriorityQueue queue = new PriorityQueue();
                queue.offer(chars[i]);
                map.put(root,queue);
            }else {
                map.get(root).offer(chars[i]);
            }
        }

        //构建result
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int root = find(parents,i);
            builder.append(map.get(root).poll());
        }

        return builder.toString();
    }
}
