/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
// */

class Solution {
    public Node copyRandomList(Node head) {
       HashMap<Node, Node>map=new HashMap<>();
       Node temp=head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
            }
        temp=head;
        while(temp!=null)
        {
            Node copy = map.get(temp);
            copy.next=map.get(temp.next);
            copy.random=map.get(temp.random);

            temp=temp.next;
        }
        return map.get(head);
    }
}
// class Solution {
//     public Node copyRandomList(Node head) {
//         copyNode(head);
//         connectRandom(head);
//         return getCopy(head);
//     }
//     public void copyNode(Node head)
//     {
//         Node temp=head;
//         while(temp!=null)
//         {
//             //Node nextElement=temp.next;
//             Node copy=new Node(temp.val);
//             copy.next= temp.next;
//             temp.next=copy;

//             temp=temp.next.next;
//         }
//     }
//     public void connectRandom(Node head)
//     {
//         Node temp=head;
//         while(temp!=null)
//         {
//             Node copyNode=temp.next;
//             if(temp.random!=null)
//             {
//                 copyNode.random=temp.random.next;
//             }
//             else{
//                 copyNode.random=null;
//             }
//             temp=temp.next.next;
//         }
//     }
//     public Node getCopy(Node head)
//     {
//         Node temp=head;
//         Node dummy=new Node(-1);
//         Node res=dummy;
//         while(temp!=null)
//         {
//             res.next=temp.next;
//             temp.next=temp.next.next;

//             res=res.next;
//             temp=temp.next;
//         }
//         return dummy.next;
//     }
// }