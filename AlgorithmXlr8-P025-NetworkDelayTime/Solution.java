import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0 ; i<=n ; i++) adj.add(new ArrayList<>());

        for(int i=0 ; i<m ; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
            adj.get(u).add(new int[]{v, wt});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[1], wt = tmp[0];

            for(int[] adjTmp : adj.get(node)) {
                int adjNode = adjTmp[0], adjWt = adjTmp[1];
                if(wt + adjWt < dist[adjNode]) {
                    pq.offer(new int[]{wt+adjWt, adjNode});
                    dist[adjNode] = wt + adjWt;
                }
            }
        }

        int ans = -1;
        for(int i=1 ; i<=n ; i++) {
            ans = Math.max(ans, dist[i]);
        }

        if(ans == (int)1e9) System.out.println(-1);
        else System.out.println(ans);
    }
}
