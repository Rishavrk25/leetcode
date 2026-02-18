/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode helper(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return null;
        if(root==p || root==q) return root;
        TreeNode l = helper(root.left,p,q);
        TreeNode r = helper(root.right,p,q);
        if(l!=null && r!=null) return root;
        else if(r==null) return l;
        else return r;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }
}