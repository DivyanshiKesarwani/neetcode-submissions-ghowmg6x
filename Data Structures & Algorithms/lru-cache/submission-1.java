class LRUCache {
    class Node{
        Node prev,next;
        int key,val;

        Node(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
    }
        HashMap<Integer,Node>map=new HashMap<>();
        int capacity;
       // Node head,tail;
        Node head=new Node(0,0);
       Node tail=new Node(0,0);
        {
            head.next=tail;
            tail.prev=head;
        }
    public LRUCache(int capacity) {
        this.capacity=capacity;
       // map=new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node node=map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key))
       {
           remove(map.get(key));
       }
       Node node=new Node(key,value);
       map.put(key,node);
       insert(node);
       if(map.size()>capacity)
       {
          Node lru=head.next;
          remove(lru);
          map.remove(lru.key);
       }

    }
    private void remove(Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void insert(Node node)
    {
        Node prevNode=tail.prev;
        prevNode.next=node;
        node.next=tail;
        node.prev=prevNode;
        tail.prev=node;
    }
}
