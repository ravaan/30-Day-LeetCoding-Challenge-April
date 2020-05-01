class Solution {
    public int maxSubArray(int[] nums) {
        int max_till_here=nums[0], max_so_far=nums[0];
        int len = nums.length;
        if(len < 2) return max_so_far;
        for(int i=1; i<len; i++) {
            max_till_here = Math.max(nums[i], max_till_here + nums[i]);
            max_so_far = Math.max(max_so_far, max_till_here);
        }
        return max_so_far;
    }
}