class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i=0;i<n.length();i++){
            char ch = n.charAt(i);
            int val = ch - '0';
            max = Math.max(max,val);
        }
        return max;
    }
}