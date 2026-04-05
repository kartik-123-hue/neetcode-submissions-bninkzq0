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
class Solution {
    int post_index;
    HashMap<Integer,Integer> index=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }
        post_index=postorder.length-1;
        return dfs(postorder,0,postorder.length-1);
    }



    public TreeNode dfs(int[] postorder,int l, int r){
        if(l>r){
            return null;
        }
        int root_val=postorder[post_index--];
        TreeNode root=new TreeNode(root_val);
        int mid=index.get(root_val);
        root.right=dfs(postorder,mid+1,r);
        root.left=dfs(postorder,l,mid-1);
        return root;

    }
}