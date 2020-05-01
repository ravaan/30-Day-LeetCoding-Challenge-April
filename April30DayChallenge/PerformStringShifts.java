class Solution {
    public String stringShift(String s, int[][] shift) {
        int sum = 0;
        for(int i=0 ;i<shift.length; i++) {
            if(shift[i][0] == 0) {
                sum -= (shift[i][1]);
            }
            else {
                sum += (shift[i][1]);
            }
        }
        char[] c = s.toCharArray();
        char[] temp = s.toCharArray();
        int len = c.length;
        for(int i=0; i<c.length; i++) {
            int sh = (i+sum)%len;
            if(sh < 0) {
                sh += len;
            }
            c[sh] = temp[i];
        }
        return String.valueOf(c);
    }
}