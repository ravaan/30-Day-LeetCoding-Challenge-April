/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int count;

    public int leftMostColumnWithOne(BinaryMatrix bm) {
        count = 0;
        List<Integer> dim = bm.dimensions();
        int row = dim.get(0);
        int col = dim.get(1);
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<row; i++) {
            int index;
            if(ans == Integer.MAX_VALUE) {
                int high_val = bm.get(i,col-1);
                count++;
                if(high_val == 0) {
                    continue;
                }
            }
            int low_val = bm.get(i,0);
            count++;
            if(low_val == 1) {
                System.out.println("calls count for ret 0 = " + count);
                return 0;
            }
            if(ans == Integer.MAX_VALUE) {
                index = search(bm, i, col, col-1);
            }
            else {
                index = search(bm, i, col, ans-1);
            }
            if(index != -1)
                ans = Math.min(ans, index);
        }
        if(ans == Integer.MAX_VALUE) {
            System.out.println("calls count for ret -1 = " + count);
            return -1;
        }
        System.out.println("calls count for ret ans = " + count);
        System.out.println("ans = " + ans);
        return ans;
    }

    public int search(BinaryMatrix bm, int row, int col,int high) {
        int low = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int mid_val = bm.get(row, mid);
            count++;
            int mid_side_val;
            if(mid_val == 1) {
                mid_side_val = bm.get(row,mid-1);
                count++;
                if(mid_side_val == 0) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}