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

// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         if(list1==null && list2==null)
//         {
//             return null;
//         }
//         if(list1==null)
//         return list2;
//         if(list2==null)return list1;
//         ArrayList<Integer>arr=new ArrayList<>();
//         ListNode temp1=list1;
//         ListNode temp2=list2;

//         while(temp1!=null){
//             arr.add(temp1.val);
//             temp1=temp1.next;
//         }
//         while(temp2!=null){
//             arr.add(temp2.val);
//             temp2=temp2.next;
//         }
//         Collections.sort(arr);
//         ListNode dummy = new ListNode(0);
//         ListNode temp = dummy;
//         for(int i=0;i<arr.size();i++)
//         {
//             temp.next = new ListNode(arr.get(i));
//             temp=temp.next;
//         }
//         return dummy.next;
//     }
// }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode dummy=new ListNode(0);
       ListNode temp=dummy;
       while(list1!=null && list2!=null)
       {
        if(list1.val<list2.val)
        {
            temp.next=list1;
            list1=list1.next;
            temp=temp.next;
        }
        else
        {
             temp.next=list2;
            list2=list2.next;
            temp=temp.next;
        }
       }
       if(list1!=null)
       {
        temp.next=list1;
       }
       else
       {
        temp.next=list2;
       }
       return dummy.next;
    }
}