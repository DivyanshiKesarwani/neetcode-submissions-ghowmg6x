class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode prevMid = middle(head);//first half last node 

        ListNode second = prevMid.next;//second half start
        prevMid.next = null;

        second = reverse(second);

        ListNode first = head;

        while(second!=null)
        {
            ListNode firstNext=first.next;
            ListNode secondNext=second.next;

            first.next=second;
            second.next=firstNext;

            first=firstNext;
            second=secondNext;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}