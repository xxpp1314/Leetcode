class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        // build the graph
        List<Integer>[] g = new ArrayList[n];
        for(int[] r: roads) {
            int a = r[0]; int b = r[1];
            if (g[a] == null) g[a] = new ArrayList<>();
            if (g[b] == null) g[b] = new ArrayList<>();
            g[a].add(b);
            g[b].add(a);
        }
        
        int m = targetPath.length;
        int[][] path = new int[n][m]; // record the path. path[i][j] stores the previous city 
                                      // for city i at position j
        int[][] dist = new int[n][m]; // dist[i][j] is the min edit distance for city i at position j
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            int da = dist[a[0]][a[1]];
            int db = dist[b[0]][b[1]];
            if (da == db) return b[1] - a[1];
            return da - db;
        });
        
        for(int i = 0; i < n; i++) {
            dist[i][0] = targetPath[0].equals(names[i]) ? 0 : 1;
            pq.offer(new int[]{i, 0});
            for(int j = 1; j < m; j++) dist[i][j] = Integer.MAX_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int[] a = pq.poll();
            int c = a[0]; int p = a[1];
            int d = dist[c][p];
            if (p == m-1) break;
            for(int b: g[a[0]]) {
                int dd = d + (targetPath[p+1].equals(names[b]) ? 0 : 1);
                if (dd < dist[b][p+1]) {
                    dist[b][p+1] = dd;
                    pq.offer(new int[]{b, p+1});
                    path[b][p+1] = c;
                }
            }
        }
        
        int last = 0;
        for(int i = 1; i < n; i++) {
            if (dist[i][m-1] < dist[last][m-1]) last = i;
        }
        
        LinkedList<Integer> ans = new LinkedList<>();
        for(int i = m-1; i >= 0; i--) {
            ans.push(last);
            last = path[last][i];
        }
        return ans;
    }
}
//https://leetcode.com/problems/the-most-similar-path-in-a-graph/discuss/788926/Java.-Dijkstra-(70ms)
