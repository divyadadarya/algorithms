// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// Note: For the purpose of this problem, we define empty string as valid palindrome.

class Solution {
    public boolean isPalindrome(String s) {
        s=s.toUpperCase();
        String ss="";
        String sss="";
        for(int i=s.length()-1;i>=0;i--)
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') || (Character.isDigit(s.charAt(i))))
                ss=ss+s.charAt(i);
        for(int i=0;i<s.length();i++)
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') || (Character.isDigit(s.charAt(i))))
                sss=sss+s.charAt(i);
        return ss.compareTo(sss)==0?true:false;
    }

    public static void main(String args[]){
        Solution a = new Solution();
        
        System.out.println(a.isPalindrome("Divya"));
        
    }
}