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
    int level(TreeNode root){
        if(root==null) return 0;
        int l=level(root.left);
        int r=level(root.right);
        return 1+Math.max(l,r);
    }
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int l=level(root.left);
        int r=level(root.right);
        int d=l+r;
        max=Math.max(max,d);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }
}