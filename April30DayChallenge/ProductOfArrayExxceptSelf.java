class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int pref[] = new int[len+1];
        int suff[] = new int[len+1];
        int output[] = new int [len];
        pref[0] = 1;
        suff[len] = 1;
        for(int i=1,j=len-1; i<=len; i++,j--) {
            pref[i] = pref[i-1]*nums[i-1];
            suff[j] = suff[j+1]*nums[j];
        }
        for(int i=0; i<len; i++) {
            output[i] = pref[i]*suff[i+1];
        }
        return output;
    }
}