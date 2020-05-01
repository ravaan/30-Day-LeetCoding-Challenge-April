class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length, pref_sum = 0, count = 0;
        // <Sum, Count>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(pref_sum, 1);
        for(int i=0; i<len; i++) {
            pref_sum += nums[i];

            if(map.containsKey(pref_sum - k)) {
                count += map.get(pref_sum-k);
            }

            if(map.isEmpty() || !map.containsKey(pref_sum)) {
                map.put(pref_sum, 1);
            }
            else {
                int val = map.get(pref_sum);
                val++;
                map.replace(pref_sum, val);
            }
        }
        return count;
    }
}

// A : 1  -1  1 -1 -1  1  1  1
// p : 1   0  1  0 -1  0  1  2
// k = 1