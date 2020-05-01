class Solution {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);
        for(int i=0; i<len; i++) {
            pq.add(stones[i]);
        }

        while(pq.size() >= 2) {
            int a,b;
            a = pq.remove();
            b = pq.remove();
            if(a == b) {
                continue;
            }
            pq.add(a-b);
        }

        if(pq.size() == 1)
            return pq.remove();
        return 0;
    }
}