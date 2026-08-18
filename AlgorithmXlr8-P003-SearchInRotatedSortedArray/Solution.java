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

        int start = 1, end = n-1;
        while(start <= end) {
            int mid = start + (end - start)/2; 

            if(nums[mid] == target) {
                System.out.println(mid);
                return;
            }

            if(nums[start] < nums[mid]) {
                if(nums[start] <= target && target <= nums[mid]) end = mid-1;
                else start = mid + 1;
            }
            else {
                if(nums[mid] <= target && target <= nums[end]) start = mid+1;
                else end = mid-1;
            }
        }

        System.out.println(-1);
        return;
    }
}
