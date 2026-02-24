class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        int j=sb.length()-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                if(sb.charAt(i)<sb.charAt(j)) sb.setCharAt(j,sb.charAt(i));
                else sb.setCharAt(i,sb.charAt(j));
            }
            i++;
            j--;
        }
        return sb.toString();
    }
}