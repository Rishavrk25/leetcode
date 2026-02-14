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
    boolean ans=true;
    int helper(TreeNode root){
        if(root==null) return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        if(Math.abs(l-r)>1) ans=false;
        return 1 + Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return ans;
    }
}