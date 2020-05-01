class Solution {
    public void moveZeroes(int[] nums) {
        int itr1=0, itr2=1;
        int len = nums.length;
        if(len < 2) return;
        while(itr1<len && nums[itr1] != 0) {
            itr1++;
            itr2++;
        }
        if(itr1 == len) return;

        while(itr2<len) {
            if(nums[itr2] != 0) {
                int temp = nums[itr2];
                nums[itr2] = nums[itr1];
                nums[itr1] = temp;
                itr1++;
            }
            itr2++;
        }
    }
}