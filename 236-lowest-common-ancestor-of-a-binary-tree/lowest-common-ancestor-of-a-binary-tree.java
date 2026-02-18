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
    boolean check(TreeNode root,TreeNode node){
        if(root==null) return false;
        if(root==node) return true;
        return check(root.left,node) || check(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q) return root;
        boolean a = check(root.left,p); // p exists in LST
        boolean b = check(root.right,q); // q exists in RST
        if((a && b) || (!a && !b)) return root; // p and q exists in opposite sides of root
        else{ // p and q exists on the same side
            if(a) return lowestCommonAncestor(root.left,p,q); // p,q exists in LST
            return lowestCommonAncestor(root.right,p,q); // p,q exists in RST
        }
    }
}