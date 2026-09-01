import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=m ; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }

            prev = Arrays.copyOf(curr, m+1);
        }

        System.out.println(curr[m]);
    }
}
