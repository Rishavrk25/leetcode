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
    int helper(TreeNode root , int l , int h){
        if(root==null) return 0;
        int left = helper(root.left,l,h);
        int right = helper(root.right,l,h);
        int sum = left + right;
        if(root.val >= l && root.val <= h) sum += root.val;
        return sum;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root,low,high);
    }
}