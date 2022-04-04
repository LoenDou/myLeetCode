package Algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_0023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list :
                lists) {
            queue.add(list);
        }

        ListNode dHead = new ListNode(-1);
        ListNode curr = dHead;
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null){
                queue.add(node.next);
            }
        }
        return dHead.next;
    }
}
