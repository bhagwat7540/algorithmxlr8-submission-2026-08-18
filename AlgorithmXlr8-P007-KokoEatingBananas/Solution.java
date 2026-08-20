import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long h = sc.nextLong();
        int[] piles = new int[n];
        for (int i = 0; i < n; i++) piles[i] = sc.nextInt();

        // Write your solution here.
        // Print the minimum speed.
        int max = 0;
        for(int pile : piles) max = Math.max(max, pile);

        int start = 1, end = max, ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;

            int hrs = 0;
            for(int pile : piles) {
                hrs += pile/mid;
                if(pile%mid != 0) hrs++;
            }

            if(hrs <= h) {
                ans = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        System.out.println(ans);
        return; 
    }
}
