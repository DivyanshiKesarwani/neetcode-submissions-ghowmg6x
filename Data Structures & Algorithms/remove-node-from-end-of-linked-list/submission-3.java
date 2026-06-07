/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)return null;
        int count=0;
        ListNode temp=head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        if(count==n)return head.next;
        temp=head;
        ListNode prev=temp;
        int pos = count - n ;//2
        for (int i=pos;i>0;i--)//2 1 0
        {
            prev=temp;
            temp=temp.next;
            //pos--;
        }
        prev.next=temp.next;
        return head;
    }
}
