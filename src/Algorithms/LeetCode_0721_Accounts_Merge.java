package Algorithms;

import java.util.*;

/**
 * @author Dou
 * @version 1.0
 * @description 并查集
 * @date 1/18/2021 20:55
 */
public class LeetCode_0721_Accounts_Merge {
    private static void union(int[] parents,int index1,int index2){
        parents[find(parents,index1)] = find(parents,index2);
    }

    private static int find(int[] parents,int index){
        while (parents[index] != index) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return new ArrayList<>();
        }

        //映射email到name
        Map<String,String> emailToName = new HashMap<>();
        //emil编号
        Map<String,Integer> emailToIndex = new HashMap<>();
        int emailCount = 0;
        //遍历建立email的映射
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                if (!emailToIndex.containsKey(acc.get(i))){
                    emailToIndex.put(acc.get(i),emailCount++);
                    emailToName.put(acc.get(i),name);
                }
            }
        }
        //构建并查集数组
        int[] parents = new int[emailCount];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        //合并相同Name的email
        for (List<String> acc : accounts) {
            String firstEmail = acc.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            for (int i = 2; i < acc.size(); i++) {
                String targetEmail = acc.get(i);
                int targetIndex = emailToIndex.get(targetEmail);
                union(parents,firstIndex,targetIndex);
            }
        }

        //将email放入合并好的index中
        Map<Integer,List<String>> putEmailToIndex = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int findIndex = find(parents,emailToIndex.get(email));
            List<String> temp = putEmailToIndex.getOrDefault(findIndex,new ArrayList<>());
            temp.add(email);
            putEmailToIndex.put(findIndex,temp);
        }
        //构建结果集
        List<List<String>> result = new ArrayList<>();
        for (List<String> ele : putEmailToIndex.values()) {
            //结果要排序
            Collections.sort(ele);
            String name = emailToName.get(ele.get(0));
            List<String> emails = new ArrayList<>();
            emails.add(name);
            emails.addAll(ele);
            result.add(emails);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("johnsmith@mail.com");
        list.add("john00@mail.com");
        accounts.add(list);
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnnybravo@mail.com");
        accounts.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnsmith@mail.com");
        list2.add("john_newyork@mail.com");
        accounts.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("Mary");
        list3.add("mary@mail.com");
        accounts.add(list3);
        accounts = accountsMerge(accounts);
        System.out.println(accounts);
    }
}
