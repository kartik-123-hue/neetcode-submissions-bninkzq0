class LRUCache {
    //this is the node (double linked list we have created)
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.prev=null;
            this.next=null;
        }
    }
    Node left;Node right;
    HashMap<Integer,Node> cache;
    int cap;

    public LRUCache(int capacity) {
        this.cap=capacity;
        this.left=new Node(0,0);
        this.right=new Node(0,0);
        this.left.next=this.right;
        this.right.prev=this.left;
        cache=new HashMap<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node curr=cache.get(key);
            remove(curr);
            insert(curr);
            return curr.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode=new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);
        if(cache.size()>cap){
            Node lru=this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void insert(Node node){
        Node prev=this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=this.right;
        this.right.prev=node;
    }

    public void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }
}
