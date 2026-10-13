import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] edges = new int[m][3];
        for(int i=0 ; i<m ; i++) {
            edges[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }
        
        Arrays.sort(edges, (a,b) -> b[0]-a[0]);
        DisjointSet ds1 = new DisjointSet(n+1), ds2 = new DisjointSet(n+1);

        int ans = 0;
        for(int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            int rootU1 = ds1.findUParent(u), rootV1 = ds1.findUParent(v);
            int rootU2 = ds2.findUParent(u), rootV2 = ds2.findUParent(v);

            if(type == 3) {
                if(rootU1 != rootV1 || rootU2 != rootV2) {
                    ds1.union(u, v);
                    ds2.union(u, v);
                }
                else ans++;
            }
            else if(type == 1) {
                if(rootU1 != rootV1) ds1.union(u, v);
                else ans++;
            }
            else {
                if(rootU2 != rootV2) ds2.union(u, v);
                else ans++;
            }
        }

        int[] size1 = ds1.getSize(), size2 = ds2.getSize();
        int max1 = 0, max2 = 0;
        for(int s : size1) max1 = Math.max(max1, s);
        for(int s : size2) max2 = Math.max(max2, s);

        if(max1 != n || max2 != n) System.out.println(-1);
        else System.out.println(ans);
    }

    private static class DisjointSet {
        private final int[] parent;
        private final int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            Arrays.fill(size, 1);
            for(int i=0 ; i<n ; i++) parent[i] = i;
        }

        public int findUParent(int node) {
            if(parent[node] == node) return node;
            return parent[node] = findUParent(parent[node]);
        }

        public void union(int u, int v) {
            int rootU = findUParent(u), rootV = findUParent(v);
            if(rootU == rootV) return;

            if(size[rootU] >= size[rootV]) {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            }
            else {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            }
        }

        public int[] getParent() {
            return this.parent;
        }

        public int[] getSize() {
            return this.size;
        }
    }
}
