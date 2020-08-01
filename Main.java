// 1) Problem for Function named -> detectCapitalUse

// Given a word, you need to judge whether the usage of capitals in it is right or not.
// We define the usage of capitals in a word to be right when one of the following cases holds:
// 1.All letters in this word are capitals, like "USA".
// 2.All letters in this word are not capitals, like "leetcode".
// 3.Only the first letter in this word is capital, like "Google".
// Otherwise, we define that this word doesn't use capitals in a right way.

class Main{
    public boolean detectCapitalUse(String word) {
        int l = word.length();
        int i;
        if (word.equals(word.toUpperCase())) {
            return true;
        }
        for(i=1;i<l;i++)
        {
            char ch = word.charAt(i);
            if ('A' <= ch  && ch <= 'Z') 
                return false;
        }
        return true;
    }
    
    public static void main(String args[]){
        Main a = new Main();
        
        System.out.println(a.detectCapitalUse("Divya"));
        
    }
}
