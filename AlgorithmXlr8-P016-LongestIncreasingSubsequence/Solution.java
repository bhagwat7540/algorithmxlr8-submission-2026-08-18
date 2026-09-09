import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
        } 

        int[] dp = new int[n];
        int max = -1;
        Arrays.fill(dp, 1);

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<i ; j++) {
                if(arr[i] > arr[j] && 1+dp[j] > dp[i]) {
                    dp[i] = 1+dp[j];
                }
            }

            if(dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }
}
