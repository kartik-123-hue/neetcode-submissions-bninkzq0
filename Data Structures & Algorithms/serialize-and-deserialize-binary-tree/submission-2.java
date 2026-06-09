/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> encode=new ArrayList<>();
        dfsToSerialise(root,encode);
        return String.join(",",encode);
    }
    public void dfsToSerialise(TreeNode root,List<String> encode){
        if(root==null){
            encode.add("#");
            return;
        }
        encode.add(String.valueOf(root.val));
        dfsToSerialise(root.left,encode);
        dfsToSerialise(root.right,encode);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataStream = data.split(",");
        int[] pointer=new int[]{0};
        return dfs(dataStream,pointer);
    }

    public TreeNode dfs(String[] dataStream,int[] pointer){
        if(dataStream[pointer[0]].equals("#")){
            pointer[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(dataStream[pointer[0]])); pointer[0]++;
        root.left=dfs(dataStream,pointer);
        root.right=dfs(dataStream,pointer);
        return root;
    }
}
