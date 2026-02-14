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
    boolean helper(TreeNode root,int sum,int t){
        if(root==null) return false;
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==t) return true;
            return false;
        }
        boolean l = helper(root.left,sum,t);
        boolean r = helper(root.right,sum,t);
        return l||r;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return helper(root,0,targetSum);
    }
}