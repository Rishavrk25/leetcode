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
    TreeNode helper(int postorder[],int inorder[], int pl,int ph,int il,int ih ){
        if(pl>ph || il > ih) return null;
        TreeNode root = new TreeNode(postorder[ph]);
        int idx = -1; // root idx in inorder array
        for(int i=0;i<inorder.length;i++){
            if(postorder[ph]==inorder[i]){
                idx=i;
                break;
            }
        }
        int size = ih-idx; // size of RST
        root.left= helper(postorder,inorder,pl,ph-size-1,il,idx-1);
        root.right=helper(postorder,inorder,ph-size,ph-1,idx+1,ih);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return helper(postorder,inorder,0,n-1,0,n-1);
    }
}