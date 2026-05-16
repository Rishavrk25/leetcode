class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_kamai = 0;
        int total_kharcha = 0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            total_kamai+=gas[i];
            total_kharcha+=cost[i];
        }
        if(total_kamai < total_kharcha) return -1;
        int total = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            total = total + gas[i] - cost[i];
            if(total < 0){
                total = 0;
                ans = i+1;
            }
        }
        return ans;

    }
}