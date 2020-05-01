class Solution {
    // O(N^2) time complexity O(N) Space complexiy
//    public boolean canJump(int[] n) {
//        boolean[] can_visit = new boolean[n.length];
//        can_visit[0] = true;
//        for(int i=0; i<n.length; i++){
//            if(!can_visit[i]) return false;
//            for(int j = 1; j<=n[i]; j++){
//                if(i+j<n.length) can_visit[i+j] = true;
//            }
//        }
//        return true;
//    }

    // O(N) time and O(N) Space
    class Solution {
        public boolean canJump(int[] n) {
            int len = n.length;
            boolean[] can_visit = new boolean[len];
            can_visit[0] = true;
            int start_from_index = 1;
            for(int i=0; i<len; i++){
                if(!can_visit[i]) return false;
                for(int j = start_from_index; j<= n[i] + i; j++){
                    if( start_from_index < len){
                        if(j == len - 1) return true;
                        can_visit[j] = true;
                        start_from_index++;
                    }
                    else break;
                }
            }
            return true;
        }
    }
}