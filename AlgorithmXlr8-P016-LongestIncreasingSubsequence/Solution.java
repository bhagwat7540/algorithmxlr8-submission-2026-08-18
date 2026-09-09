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

        List<Integer> tmp = new ArrayList<>();
        tmp.add(arr[0]);

        for(int i=1 ; i<n ; i++) {
            if(arr[i] > tmp.get(tmp.size()-1)) tmp.add(arr[i]);
            else {
                int ind = lowerBound(arr[i], tmp);
                tmp.set(ind, arr[i]);
            }
        }

        System.out.println(tmp.size());

        // int[] dp = new int[n];
        // int max = -1;
        // Arrays.fill(dp, 1);

        // for(int i=0 ; i<n ; i++) {
        //     for(int j=0 ; j<i ; j++) {
        //         if(arr[i] > arr[j] && 1+dp[j] > dp[i]) {
        //             dp[i] = 1+dp[j];
        //         }
        //     }

        //     if(dp[i] > max) max = dp[i];
        // }

        // System.out.println(max);
    }

    private static int lowerBound(int x, List<Integer> tmp) {
        int start = 0, end = tmp.size()-1;
        int ans = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(tmp.get(mid) >= x) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
