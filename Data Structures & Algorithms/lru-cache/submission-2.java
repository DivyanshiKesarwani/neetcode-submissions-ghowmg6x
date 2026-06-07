class LRUCache {

    class Node
    {
        Node prev,next;
        int key,val;
        Node(int key,int value)
        {
            this.val=value;
            this.key=key;
        }
    }
    int capacity;
    HashMap<Integer,Node>map;
    
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node res=map.get(key);
        remove(res);
        insert(res);
        return res.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        Node newNode=new Node(key,value);
        map.put(key,newNode);
        insert(newNode);
        if(map.size()>capacity){
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
