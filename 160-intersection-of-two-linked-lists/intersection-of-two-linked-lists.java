/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m =0, n=0;
        ListNode temp = headA;
        while(temp!=null){
            m++;
            temp = temp.next;
        }
        temp = headB;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        ListNode thA = headA;
        ListNode thB = headB;
        if(m>n){
            while(m>n){
                m--;
                thA= thA.next;
            }
        }else{
            while(n>m){
                n--;
                thB = thB.next;
            }
        }
        while(thA!=null){
            if(thA==thB){
                return thA;
            }
            thA = thA.next;
            thB = thB.next;
        }
        return thA;
    }
}