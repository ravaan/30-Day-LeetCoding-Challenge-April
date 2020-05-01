class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n) return m;
        int logm = findLog(m);
        int logn = findLog(n);
        if(logm != logn) return 0;
        int ans = 0;
        for(int i=logm; i >= 0; --i){
            int bit = 1 << i;
            if(((bit & m )!= 0) && ((bit & n) != 0)) {
                int x = (int)Math.pow(2, i);
                if((n-m) < x){
                    ans += Math.pow(2, i);
                }
            }
            else continue;
        }
        return ans;
    }
    public int findLog(int x){
        int log = 0;
        while(x > 1){
            x /= 2;
            log++;
        }
        return log;
    }
}

// 0           0
// 1           1
// 2          10
// 3          11
// 4         100
// 5         101
// 6         110
// 7         111
// 8        1000
// 9        1001
// 10       1010
// 11       1011
// 12       1100
// 13       1101
// 14       1110
// 15       1111
// 16      10000