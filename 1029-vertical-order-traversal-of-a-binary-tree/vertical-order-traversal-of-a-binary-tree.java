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
class Triplet{
    TreeNode node;
    int idx;
    int level;
    Triplet(TreeNode node,int idx,int level){
        this.node=node;
        this.idx=idx;
        this.level=level;
    }
}
class Solution {
    // void helper(TreeNode root,int idx,int level,PriorityQueue<int[]> q){
    //     if(root==null) return;
    //     q.add(new int[]{root.val,idx,level});
    //     helper(root.left,idx-1,level+1,q);
    //     helper(root.right,idx+1,level+1,q);
    // }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // min heap --> (node,idx,level)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1] && a[2]==b[2]) return Integer.compare(a[0],b[0]); // idx,level
            if(a[1]==b[1]) return Integer.compare(a[2],b[2]); // idx
            else return Integer.compare(a[1],b[1]);
        }); 
        // helper(root,0,0,q);
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root,0,0));
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Triplet t = q.remove();
                TreeNode node = t.node;
                int idx = t.idx;
                int level = t.level;
                pq.add(new int[]{node.val,idx,level});
                if(node.left!=null) q.add(new Triplet(node.left,idx-1,level+1));
                if(node.right!=null) q.add(new Triplet(node.right,idx+1,level+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        int top[] = pq.peek();
        int minIdx = top[1];
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            int t[] = pq.remove();
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