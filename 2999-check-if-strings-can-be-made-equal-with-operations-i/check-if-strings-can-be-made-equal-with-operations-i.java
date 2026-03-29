class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        // swap1
        StringBuilder sb = new StringBuilder(s1);
        char temp = sb.charAt(0);
        sb.setCharAt(0,sb.charAt(2));
        sb.setCharAt(2,temp);
        if(sb.toString().equals(s2)) return true;
        // swap2
        sb = new StringBuilder(s1);
        temp = sb.charAt(1);
        sb.setCharAt(1,sb.charAt(3));
        sb.setCharAt(3,temp);
        if(sb.toString().equals(s2)) return true;
        // both swap
        sb = new StringBuilder(s1);
        temp = sb.charAt(0);
        sb.setCharAt(0,sb.charAt(2));
        sb.setCharAt(2,temp);
        temp = sb.charAt(1);
        sb.setCharAt(1,sb.charAt(3));
        sb.setCharAt(3,temp);
        if(sb.toString().equals(s2)) return true;
        return false;

    }
}