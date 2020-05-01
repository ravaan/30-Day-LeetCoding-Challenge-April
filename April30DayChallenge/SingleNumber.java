class Solution {
    public int singleNumber(int[] n) {
        int ans = n[0];
        for(int i = 1; i < n.length; i++)
            ans = ans^n[i];
        return ans;
    }
}