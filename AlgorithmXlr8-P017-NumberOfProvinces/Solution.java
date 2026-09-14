import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) adj.add(new ArrayList<>());

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                int x = sc.nextInt();
                if(i != j && x == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i=0 ; i<n ; i++) {
            if(!vis[i]) {
                dfs(i, vis, adj);
                // bfs(i, vis, adj);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int node, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;

        for(int adjNode : adj.get(node)) {
            if(!vis[adjNode]) {
                dfs(adjNode, vis, adj);
            }
        }
    }

    private static void bfs(int node, boolean[] vis, List<List<Integer>> adj) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        vis[node] = true;

        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            for(int adjNode : adj.get(currNode)) {
                if(!vis[adjNode]) {
                    queue.offer(adjNode);
                    vis[adjNode] = true;
                }
            }
        }
    }
}
