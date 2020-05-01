class Solution {
    public int search(int[] n, int t) {
        int len = n.length;
        if(len == 0) return -1;
        int hi = len - 1, lo = 0;
        boolean t_big = (t >= n[0]);
        while(hi >= lo){
            int mid = lo + (hi - lo) / 2;
            if(n[mid] == t) return mid;
            boolean am_big = (n[mid] >= n[0]);
            if (am_big == t_big){
                if(n[mid] > t) hi = mid -1;
                else lo = mid + 1;
            }
            else{
                if(am_big) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}