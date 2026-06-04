class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0); // dummy head = LRU side
        tail = new Node(0, 0); // dummy tail = MRU side

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);   // remove from current position
        insert(node);   // insert near tail because it is recently used

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

        if (map.size() > capacity) {
            Node lru = head.next;   // least recently used
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        Node prevNode = tail.prev;

        prevNode.next = node;
        node.prev = prevNode;

        node.next = tail;
        tail.prev = node;
    }
}