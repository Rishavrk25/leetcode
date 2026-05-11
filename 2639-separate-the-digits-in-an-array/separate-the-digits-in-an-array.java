class Solution {
    public int[] separateDigits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int ele:arr){
            String s = ""+ele;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                list.add((int)(ch-'0'));
            }
        }
        int ans[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}