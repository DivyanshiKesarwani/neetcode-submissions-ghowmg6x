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
    //time complexity: (N1)+(N1+N2)+(N1+N2+N3)+...(N1+N2+..+Nk)
    //N(1+2+3..+k)~ Nk(k+1)/2
// public ListNode mergeKLists(ListNode[] lists) {
//     if(lists.length == 0) return null;

//     ListNode result = lists[0];

//     for(int i = 1; i < lists.length; i++) {
//         result = mergeTwoLists(result, lists[i]);
//     }

//     return result;
// }
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//       ListNode dummy =new ListNode(0);
//       ListNode temp=dummy;
//       while(list1!=null && list2!=null)
//       {
//         if(list1.val<list2.val)
//         {
//             temp.next=list1;
//             list1=list1.next;
//             temp=temp.next;
//         }
//         else
//         {
//             temp.next=list2;
//             list2=list2.next;
//             temp=temp.next;
//         }
//       }
//       if(list1!=null)
//       {
//         temp.next=list1;
//       }
//       else
//       {
//         temp.next=list2;
//       }
//       return dummy.next;
//     }
//PRIORITY QUEUE takes log N where N is the size of queue
//time complexity: k*logk + N*k*3*logk
//space: k
        public ListNode mergeKLists(ListNode[] lists)
        {
             PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

            for (int i = 0; i < lists.length; i++) 
            {
            if (lists[i] != null) 
                {
                pq.add(lists[i]);
                }
            }
            ListNode dummy=new ListNode(0);
            ListNode temp=dummy;
            while(!pq.isEmpty())
            {
                ListNode node=pq.poll();
                temp.next=node;
                temp=temp.next;
                if(node.next!=null)
                {
                    pq.add(node.next);
                }
            }
            return dummy.next;
        }
}
