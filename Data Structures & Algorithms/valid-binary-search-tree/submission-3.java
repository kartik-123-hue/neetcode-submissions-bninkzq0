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
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<Object[]> queue=new LinkedList<>();
        Object[] obj=new Object[]{root,Long.MIN_VALUE,Long.MAX_VALUE};
        queue.offer(obj);
        while(!queue.isEmpty()){
            Object[] objArray=queue.poll();
            TreeNode node=(TreeNode) objArray[0];
            long min=(long) objArray[1];
            long max=(long) objArray[2];
            if(!(node.val>min && node.val<max)){
                return false;
            }
            if(node.left!=null){
                queue.offer(new Object[]{node.left,min,(long) node.val});
            }
            if(node.right!=null){
                queue.offer(new Object[]{node.right,(long) node.val,max});
            }
        }
        return true;
    }
}
