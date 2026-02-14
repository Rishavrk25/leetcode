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
    int helper(TreeNode root){
        if(root==null) return 0;
        int l = 1 + helper(root.left);
        int r = 1 + helper(root.right);
        return Math.max(l,r);
    }
    public int maxDepth(TreeNode root) {
        return helper(root);
    }
}