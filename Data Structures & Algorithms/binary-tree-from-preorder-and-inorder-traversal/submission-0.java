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
    int pre_index=0;
    HashMap<Integer,Integer> index=new HashMap<>();
 /**
    the approach is 
    inorder trav mean it goes from left -> right
    so it has all the left and right nodes of the tree

    preorder trav mean it starts from the top and keeps on going
    to the left or right untill it has coverred all nodes

    so now the approach is 
    preorder first node will always be root
    preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

    root =3  we can find the tree in inorder [9,3,15,20,7]
    this root(3) will split the arrays into 2 parts why?

    because in order trav is from left to right so left will have all the nodes to the right all the nodes will be present 
  */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }
        return dfs(preorder,0,preorder.length-1);
    }

    public TreeNode dfs(int[] preorder,int l,int r){
        if(l>r) return null;
        int root_val=preorder[pre_index++];
        TreeNode root=new TreeNode(root_val);
        int mid=index.get(root_val);
        root.left=dfs(preorder,l,mid-1);
        root.right=dfs(preorder,mid+1,r);
        return root;
    }
}