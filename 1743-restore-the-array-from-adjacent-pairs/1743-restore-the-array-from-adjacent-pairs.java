class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
        
        for (int[] adj : adjacentPairs) {
            g.computeIfAbsent(adj[0], k -> new HashSet<Integer>()).add(adj[1]);
            g.computeIfAbsent(adj[1], k -> new HashSet<Integer>()).add(adj[0]);
        }
        
        // System.out.println(g);
        Stack<Integer> st = new Stack<>();
        for (int k : g.keySet()) {
            if (g.get(k).size() == 1) {
                st.push(k);
                break;
            }
        }
        
        int[] res = new int[g.size()];
        HashSet<Integer> seen = new HashSet<>();
        int i = 0;
        
        while (!st.isEmpty()) {
            int cur = st.pop();
            res[i++] = cur;
            seen.add(cur);
            
            for (int nei : g.get(cur)) {
                if (!seen.contains(nei)) {
                    st.push(nei);
                }
            }
        }
        
        return res;
    }
}