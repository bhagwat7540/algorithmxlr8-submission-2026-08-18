import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<String>> list = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            list.add(new ArrayList<>());
            String name = sc.next();
            list.get(i).add(name);

            int k = sc.nextInt();
            for(int j=0 ; j<k ; j++) {
                String mail = sc.next();
                list.get(i).add(mail);
            }
        }

        Map<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for(int i=0 ; i<n ; i++) {
            for(int j=1 ; j<list.get(i).size() ; j++) {
                String mail = list.get(i).get(j);
                if(!map.containsKey(mail)) map.put(mail, i);
                else ds.union(i, map.get(mail));
            }
        }

        List<List<String>> tmp = new ArrayList<>();
        for(int i=0 ; i<n ; i++) tmp.add(new ArrayList<>());
        for(String mail : map.keySet()) {
            int index = map.get(mail);
            int uIndex = ds.findUParent(index);
            tmp.get(uIndex).add(mail);
        }

        for(int i=0 ; i<n ; i++) {
            List<String> l = tmp.get(i);
            if(l.size() == 0) continue;
            Collections.sort(l);

            String name = list.get(i).get(0);
            System.out.print(name + " ");
            for(int j=0 ; j<l.size() ; j++) {
                System.out.print(l.get(j));
                if(j != l.size()-1) System.out.print(" ");
            }

            if(i != n-1) System.out.println();
        }
    }

    private static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            Arrays.fill(size, 1);
            for(int i=0 ; i<n ; i++) parent[i] = i;
        }

        public int findUParent(int node) {
            if(node == parent[node]) return node;
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
    } 
}
