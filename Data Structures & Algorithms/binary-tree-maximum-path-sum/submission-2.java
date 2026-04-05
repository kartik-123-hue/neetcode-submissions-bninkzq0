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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //three possibilites
        //one we can consider the path from left to right
        //that is for 2->1->3 =6
        //another check from left or right if that is the max including left
        //and right and then going downward
        //another is contribution from current to root however this can be calculated 
        //with the first one 

        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        int left=getMax(root.left);
        int right=getMax(root.right);
        //checking if the current node path from left to right gives max
        res=Math.max(res,root.val+left+right);
        dfs(root.left);
        dfs(root.right);
    }
    public int getMax(TreeNode root){
        if(root==null){
            return 0;
        }
        //checking if there is max from left to right 
        int left=getMax(root.left);
        int right=getMax(root.right);
        //which ever is max from current to parent 3rd point 
        int path=Math.max(left,right)+root.val;
        // we add 0 because ngative left or right will ruin 
        //our path more
        return Math.max(path,0);
    }
}
