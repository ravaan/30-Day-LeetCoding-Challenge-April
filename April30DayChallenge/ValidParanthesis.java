class Solution {
    public boolean checkValidString(String s) {
        int balance = 0;
        char[] ch = s.toCharArray();
        for(char c: ch)
            if(c == '(' || c == '*') balance++;
            else if( --balance == -1) return false;
        balance = 0;
        for(int i = ch.length - 1; i >= 0; i--)
            if(ch[i] == ')' || ch[i] == '*') balance++;
            else if(--balance == -1) return false;
        return true;
    }
}