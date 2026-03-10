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
    TreeNode iop(TreeNode root){
        TreeNode pred = root.left;
        while(pred.right!=null) pred = pred.right;
        return pred;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key==root.val){
            // 0 child
            if(root.left==null && root.right==null){
                return null;
            }
            // 1 child
            else if(root.left == null || root.right==null){
                if(root.left==null) return root.right;
                else return root.left;
            }
            // 2 child
            else{
                TreeNode pred = iop(root);
                root.val = pred.val;
                root.left = deleteNode(root.left,pred.val);
            }
        }
        else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}