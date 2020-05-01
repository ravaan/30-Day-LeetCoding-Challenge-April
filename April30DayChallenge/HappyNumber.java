class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        HashSet<Integer> set = new HashSet();
        int num = 0;
        int sum = 0;
        int digit = 0;
        do{
            sum = 0;
            while(n != 0) {
                digit = n%10;
                n = n/10;
                sum += digit*digit;
            }
            if(set.contains(new Integer(sum))) {
                return false;
            }
            n = sum;
            set.add(n);
        }while(n != 1);

        return true;
    }
}