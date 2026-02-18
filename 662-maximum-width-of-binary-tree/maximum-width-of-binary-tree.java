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
class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int width = q.peekLast().idx-q.peekFirst().idx+1;
            max = Math.max(max,width);
            for(int i=0;i<size;i++){
                Pair p = q.remove();
                TreeNode node = p.node;
                int idx = p.idx;
                if(node.left!=null) q.add(new Pair(node.left,2*idx+1));
                if(node.right!=null) q.add(new Pair(node.right,2*idx+2));
            }
        }
        return max;
    }
}