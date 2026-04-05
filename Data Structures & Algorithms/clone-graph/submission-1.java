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
    public Node cloneGraph(Node node) {
        //this is same as marking 
        //a node as visited
        // we keep a track of the visited node 
        //and its new node created
        Map<Node,Node> mapOldToNew=new HashMap<>();
        //search a trail and then move to next one
        return dfs(node,mapOldToNew);
    }
    public Node dfs(Node node,Map<Node,Node> mapOldToNew){
        //if reach null then we have reached the end;
        if(node==null){
            return node;
        }
        //if we dont reach we reach an already visited node
        //whos copy is already made
        if(mapOldToNew.containsKey(node)){
            return mapOldToNew.get(node);
        }
        //create a copy
        Node copy=new Node(node.val);
        mapOldToNew.put(node,copy);
        //add its neighbors
        for(Node nei:node.neighbors){
            copy.neighbors.add(dfs(nei,mapOldToNew));
        }
        return copy;
    }
}