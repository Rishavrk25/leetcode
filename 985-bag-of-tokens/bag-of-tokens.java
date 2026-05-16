class Solution {
    public int bagOfTokensScore(int[] arr, int power) {
        int n=arr.length;
        Arrays.sort(arr);
        int i=0;
        int j=n-1;
        int score = 0;
        int ans = 0;
        while(i<=j){
            if(power >= arr[i]){
                score++;
                power-=arr[i];
                i++;
            }
            else{
                if(score>=1){
                    score--;
                    power+=arr[j];
                }
                j--;
            }
            ans = Math.max(ans,score);
        }
        return ans;
    }
}