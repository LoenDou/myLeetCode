package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/24/2021 22:56
 */
public class LeetCode_0086_Partition_List {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return head;
        }
        //虚拟头结点  一前一后两个链表
        ListNode preNode = new ListNode(-1);
        ListNode postNode = new ListNode(-1);

        ListNode pre = preNode;
        ListNode post = postNode;

        while (head != null){
            if (head.val < x){
                pre.next = head;
                pre = pre.next;
            }else {
                post.next = head;
                post = post.next;
            }
            head = head.next;
        }

        post.next = null;
        pre.next = postNode.next;

        return preNode.next;
    }
}
