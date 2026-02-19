class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];
        for(int arr[]:bookings){
            int l=arr[0]-1;
            int r=arr[1]-1;
            int seats = arr[2];
            ans[l]+=seats;
            if(r+1<n) ans[r+1]-=seats;
        }
        for(int i=1;i<n;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}