class Solution {
    int bs(List<Integer> arr,int t){
        int l=0;
        int h=arr.size()-1;
        while(l<=h){
            int m=(l+h)/2;
            if(arr.get(m)<t) l=m+1;
            else h=m-1;
        }
        return l;
    }
    public List<Integer> solveQueries(int[] arr, int[] queries) {
        int n=arr.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }
            else map.get(arr[i]).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for(int idx:queries){
            List<Integer> list = map.get(arr[idx]);
            if(list.size()<=1){
                ans.add(-1);
                continue;
            }
            // int x = -1; // finding idx in list
            // for(int i=0;i<list.size();i++){
            //     int ele = list.get(i);
            //     if(ele==idx){
            //         x=i;
            //         break;
            //     }
            // }
            int x = bs(list,idx);

            int next = (x+1)%list.size();
            int d = Math.abs(list.get(next) - list.get(x));
            int cd = Math.abs(n-d);

            int prev = (x-1+list.size())%list.size();
            int d1 = Math.abs(list.get(prev) - list.get(x));
            int cd1 = Math.abs(n-d1);
            ans.add(Math.min(Math.min(d,cd),Math.min(d1,cd1)));
        }
        return ans;
    }
}