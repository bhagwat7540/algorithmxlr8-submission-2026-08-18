import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] prices = new long[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextLong();

        long min = Long.MAX_VALUE, ans = 0;
        for(long price : prices) {
            min = Math.min(price, min);
            ans = Math.max(ans, price - min);
        }

        System.out.println(ans);

        // Write your solution here.
        // Print the maximum profit achievable from a single buy followed by a
        // single later sell, or 0 if no profit is possible.
    }
}
