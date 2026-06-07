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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }
        return tree(preorder,0,preorder.length-1);
    }
    public TreeNode tree(int[] preorder,int left,int right){
        if(left>right){
            return null;
        }
        int root=preorder[preIndex++];
        int mid=index.get(root);
        TreeNode newTree=new TreeNode(root);
        newTree.left=tree(preorder,left,mid-1);
        newTree.right=tree(preorder,mid+1,right);
        return newTree;
    }
}
