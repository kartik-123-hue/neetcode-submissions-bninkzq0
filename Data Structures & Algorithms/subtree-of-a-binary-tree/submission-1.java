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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.val==subRoot.val && checkIfEquals(node,subRoot)){
                return true;
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return false;
    }
    private boolean checkIfEquals(TreeNode root,TreeNode subRoot){
        Stack<TreeNode[]> stack=new Stack();
        stack.push(new TreeNode[]{root,subRoot});
        while(!stack.isEmpty()){
            TreeNode[] nodes=stack.pop();
            TreeNode nodeRoot=nodes[0];
            TreeNode nodeSubRoot=nodes[1];
            if(nodeRoot==null && nodeSubRoot==null){
                continue;
            }
            if(nodeRoot==null || nodeSubRoot==null || nodeRoot.val!=nodeSubRoot.val){
                return false;
            }
            stack.push(new TreeNode[] {nodeRoot.left,nodeSubRoot.left});
            stack.push(new TreeNode[] {nodeRoot.right,nodeSubRoot.right});
        }
        return true;
    }

}
