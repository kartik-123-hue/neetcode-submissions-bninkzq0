/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> table=new HashMap<>();
    public Node cloneGraph(Node node) {
        Node temp=dfs(node);
        return temp;
    }
    public Node dfs(Node head){
        if(head==null){
            return null;
        }
        Node newNode=new Node(head.val);
        table.put(head,newNode);
        for(Node nei:head.neighbors){
            if(table.containsKey(nei)){
                newNode.neighbors.add(table.get(nei));
            }
            else{
                newNode.neighbors.add(dfs(nei));
            }
        }
        return newNode;
    }

}