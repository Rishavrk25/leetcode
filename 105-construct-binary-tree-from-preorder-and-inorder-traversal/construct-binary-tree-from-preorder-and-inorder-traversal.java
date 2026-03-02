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
    TreeNode helper(int preorder[],int inorder[],int pl,int ph,int il,int ih){
        if(pl>ph || il>ih) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int idx = -1; // root idx in inorder array
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[pl]){
                idx=i;
                break;
            }
        }
        int size = idx - il; // size of LST
        root.left = helper(preorder,inorder,pl+1,pl+size,il,idx-1);
        root.right = helper(preorder,inorder,pl+size+1,ph,idx+1,ih);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return helper(preorder,inorder,0,n-1,0,n-1);
    }
}