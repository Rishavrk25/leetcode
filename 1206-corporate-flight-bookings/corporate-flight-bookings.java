class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];
        for(int arr[]:bookings){
            int l=arr[0]-1;
            int r=arr[1]-1;
            int seats = arr[2];
            for(int i=l;i<=r;i++){
                ans[i]+=seats;
            }
        }
        return ans;
    }
}