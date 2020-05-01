class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            if(!stk.empty() && s.charAt(i) == '#') stk.pop();
            else if(s.charAt(i) != '#') stk.push(s.charAt(i));
        }
        s = stk.toString();
        stk.clear();
        for(int i = 0; i<t.length(); i++){
            if(!stk.empty() && t.charAt(i) == '#') stk.pop();
            else if(t.charAt(i) != '#') stk.push(t.charAt(i));
        }
        t = stk.toString();
        if(s.equals(t)) return true;
        return false;
    }
}