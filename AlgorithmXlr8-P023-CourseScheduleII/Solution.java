import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i=0 ; i<n ; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n];
        for(int i=0 ; i<m ; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(v).add(u);
            indegree[u]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0 ; i<n ; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for(int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }

        if(topo.size() == n) {
            for(int i : topo) System.out.print(i + " ");
        }
    }
}
