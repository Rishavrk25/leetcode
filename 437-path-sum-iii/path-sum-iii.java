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
    int c=0;
    void helper(TreeNode root,long sum,int t){
        if(root==null) return;
        sum+=root.val;
        if(sum==t) c++;
        helper(root.left,sum,t);
        helper(root.right,sum,t);
    }
    public int pathSum(TreeNode root, int t) {
        if(root==null) return 0;
        helper(root,0,t);
        pathSum(root.left,t);
        pathSum(root.right,t);
        return c;
    }
}