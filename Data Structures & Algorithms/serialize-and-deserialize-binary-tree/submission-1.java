/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> encode=new ArrayList<>();
        serDfs(root,encode);
        return String.join(",",encode);
    }

    public void serDfs(TreeNode root,List<String> encode){
        if(root==null){
            encode.add("N");
            return;
        }
        encode.add(String.valueOf(root.val));
        serDfs(root.left,encode);
        serDfs(root.right,encode);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String[] dataStream=data.split(",");
       int[] i={0};
       return desDfs(dataStream,i);
    }
    public TreeNode desDfs(String[] dataStream,int[] pointer){
        if(dataStream[pointer[0]].equals("N")){
             pointer[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(dataStream[pointer[0]]));
        pointer[0]++;
        root.left=desDfs(dataStream,pointer);
        root.right=desDfs(dataStream,pointer);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));