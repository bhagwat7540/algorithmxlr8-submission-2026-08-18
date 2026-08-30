import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] p = new int[n];
        for(int i=0 ; i<n  ; i++) p[i] = sc.nextInt();

        int[] curr = new int[2];
        int[] nxt1 = new int[2];
        int[] nxt2 = new int[2];

        for(int i=n-1 ; i>=0 ; i--) {
            curr[0] = Math.max(-p[i] + nxt1[1], nxt1[0]);
            curr[1] = Math.max(p[i] + nxt2[0], nxt1[1]);

            nxt2 = Arrays.copyOf(nxt1, 2);
            nxt1 = Arrays.copyOf(curr, 2);
        }

        System.out.println(curr[0]);
    }
}