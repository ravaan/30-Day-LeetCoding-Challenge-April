class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int answer = 0;
        for(int i=0; i<len; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }

        int[] pref = new int[len+1];
        pref[0] = 0;
        for(int i=0; i<len; i++) {
            pref[i+1] = pref[i] + nums[i];
        }

        HashMap<Integer, Integer> first_oc = new HashMap<>();
        for(int i=0; i<len+1; i++) {
            int x = pref[i];
            if(first_oc.containsKey(x)) {
                answer = Math.max(answer, i-first_oc.get(x));
            }
            else {
                first_oc.put(x,i);
            }
        }
        return answer;
    }
}