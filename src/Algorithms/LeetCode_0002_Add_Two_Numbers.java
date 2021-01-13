package Algorithms;

/**
 * @author Dou
 * @version 1.0
 * @description
 * @date 1/14/2021 2:51
 */
public class LeetCode_0002_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return null;
        }
        ListNode dhead = new ListNode(-1);
        ListNode p1 = l1,p2=l2,cur = dhead;
        int isplus = 0;
        while(p1!=null||p2!=null){
            int x = (p1!=null)?p1.val:0;
            int y = (p2!=null)?p2.val:0;
            int sum = x+y+isplus;
            isplus = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            if(p1!=null){
                p1 = p1.next;
            }
            if(p2!=null){
                p2 = p2.next;
            }
        }

        if(isplus>0){
            cur.next = new ListNode(isplus);
        }
        return dhead.next;
    }
}
