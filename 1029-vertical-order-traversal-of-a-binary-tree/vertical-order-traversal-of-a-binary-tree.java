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
    void helper(TreeNode root,int idx,int level,PriorityQueue<int[]> q){
        if(root==null) return;
        q.add(new int[]{root.val,idx,level});
        helper(root.left,idx-1,level+1,q);
        helper(root.right,idx+1,level+1,q);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // min heap --> (node,idx,level)
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1] && a[2]==b[2]) return Integer.compare(a[0],b[0]); // idx,level
            if(a[1]==b[1]) return Integer.compare(a[2],b[2]); // idx
            else return Integer.compare(a[1],b[1]);
        }); 
        helper(root,0,0,q);
        List<List<Integer>> ans = new ArrayList<>();
        int top[] = q.peek();
        int minIdx = top[1];
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int t[] = q.remove();
            int idx=t[1];
            if(idx==minIdx) list.add(t[0]);
            else{
                minIdx = idx;
                ans.add(new ArrayList<>(list));
                list.clear();
                list.add(t[0]);
            }
        }
        ans.add(list);
        return ans;

    }
}