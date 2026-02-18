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
    String path;
    Pair(TreeNode node,String path){
        this.node=node;
        this.path=path;
    }
}
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,""));
        while(!q.isEmpty()){
            Pair p = q.remove();
            TreeNode node = p.node;
            String path = p.path;
            if(path.length()!=0) path+="->";
            path+=node.val;
            if(node.left==null && node.right==null){
                ans.add(path);
            }
            if(node.left!=null) q.add(new Pair(node.left,path));
            if(node.right!=null) q.add(new Pair(node.right,path));
        }
        return ans;
    }
}