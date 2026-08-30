import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];
        for(int i=0 ; i<n ; i++) prices[i] = sc.nextInt();

        int[] curr = new int[5];
        int[] next = new int[5];

        for(int i=n-1 ; i>=0 ; i--) {
            for(int j=3 ; j>=0 ; j--) {
                
                if(j%2 == 0) {
                    curr[j] = Math.max(-prices[i] + next[j+1], next[j]);
                }
                else {
                    curr[j] = Math.max(prices[i] + next[j+1], next[j]);
                }
            }

            next = curr;
        }

        System.out.println(curr[0]);
    }
}
