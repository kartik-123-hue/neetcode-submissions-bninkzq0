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
    public int kthSmallest(TreeNode root, int k) {
        int[] res=new int[2];
        res[0]=k;
        dfs(root,res);
        return res[1];
    }

    public void dfs(TreeNode root,int[] res){
        if(root==null){
            return;
        }
        dfs(root.left,res);
        if(res[0]!=0){
            res[0]--;
            res[1]=root.val;
        }
        dfs(root.right,res);
    }
}
