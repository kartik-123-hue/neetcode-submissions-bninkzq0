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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP=new Stack<>();
        Stack<TreeNode> stackQ=new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        while(!stackP.isEmpty() && !stackQ.isEmpty()){
            TreeNode currP=stackP.pop();
            TreeNode currQ=stackQ.pop();
            if(currP==null && currQ==null){
                continue;
            }
            if(currP==null || currQ==null || currP.val!=currQ.val){
                return false;
            }
            if(currP!=null && currQ!=null){
                stackP.push(currP.left);
                stackQ.push(currQ.left);
                stackP.push(currP.right);
                stackQ.push(currQ.right);
            }
        }
        return true;
    }
}
