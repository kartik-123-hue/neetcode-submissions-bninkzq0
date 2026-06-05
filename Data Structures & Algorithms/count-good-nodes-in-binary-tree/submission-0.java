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
    public int goodNodes(TreeNode root) {
        int[] res=new int[1];
        dfs(root,res,root.val);
        return res[0];
    }
    public void dfs(TreeNode root,int[] res,int prevVal){
        if(root==null){
            return;
        }
        if(prevVal<=root.val){
            prevVal=root.val;
            res[0]++;
        }
        dfs(root.left,res,prevVal);
        dfs(root.right,res,prevVal);
    }
}
