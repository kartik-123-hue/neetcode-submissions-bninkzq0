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
    HashMap<Integer,Integer> index;
    int pre_index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }
        System.out.println(index.toString());
        return dfs(preorder,0,preorder.length-1);
    }
    public TreeNode dfs(int[] preorder,int left,int right){
        if(left>right){
            return null;
        }
        int rootVal=preorder[pre_index++];
        TreeNode root=new TreeNode(rootVal);
        int mid=index.get(rootVal);
        root.left=dfs(preorder,left,mid-1);
        root.right=dfs(preorder,mid+1,right);
        return root;
    }
}
