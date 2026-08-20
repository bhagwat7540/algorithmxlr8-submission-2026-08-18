import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), days = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) weights[i] = sc.nextInt();

        // Write your solution here.
        // Print the minimum capacity.
        int sum = 0;
        for(int wt : weights) sum += wt;

        int start = 1, end = sum, ans = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            int w = 0, d = 1;
            for(int wt : weights) {
                if(w + wt <= mid) w += wt;
                else {
                    d++;
                    w = wt;
                }
            }

            if(d <= days) {
                ans = mid;
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
