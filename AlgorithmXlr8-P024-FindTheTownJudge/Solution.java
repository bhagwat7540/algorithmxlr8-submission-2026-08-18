import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int i=0 ; i<m ; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            indegree[v]++;
            outdegree[u]++;
        }

        for(int i=0 ; i<=n ; i++) {
            if(indegree[i] == n-1 && outdegree[i] == 0) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
