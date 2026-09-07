import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();

        int n = s.length(), m = p.length();

        boolean[] curr = new boolean[m+1], prev = new boolean[m+1];

        prev[0] = true;
        for(int j=1 ; j<=m ; j++) {
            if(prev[j-1] == true && p.charAt(j-1) == '*') prev[j] = true;
            else break;
        }

        for(int i=1 ; i<=n ; i++) {
            curr[0] = false;
            for(int j=1 ; j<=m ; j++) {
                if(p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) curr[j] = prev[j-1];
                else if(p.charAt(j-1) == '*') curr[j] = prev[j] || curr[j-1];
                else curr[j] = false;
            }

            boolean[] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        System.out.println(prev[m]);
    }
}
