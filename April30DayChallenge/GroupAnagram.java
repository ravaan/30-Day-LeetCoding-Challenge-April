class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<String, List<String>>();
        for(String s: strs) {
            char ca[] = s.toCharArray();
            Arrays.sort(ca);
            String s2 = String.valueOf(ca);
            if(m.get(s2) == null) {
                m.put(s2, new ArrayList<String>());
            }
            m.get(s2).add(s);
        }

        List<List<String>> answer = new ArrayList<List<String>>();
        for(String a: m.keySet()) answer.add(m.get(a));
        return answer;
    }
}