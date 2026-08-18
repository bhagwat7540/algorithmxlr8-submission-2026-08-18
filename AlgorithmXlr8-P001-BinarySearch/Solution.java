import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int target = sc.nextInt();

        // Write your solution here.
        // Print the index, or -1.

        int start = 0, end = n-1;
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                System.out.println(mid);
                return;
            }
            else if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }

        System.out.println(-1);
        return;
    }
}
