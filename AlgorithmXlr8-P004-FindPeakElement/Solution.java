import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        // Write your solution here.
        // Print the index of any peak element.
        if(n == 1) {
            System.out.println(0);
            return;
        }
        if(nums[0] > nums[1]) {
            System.out.println(1);
            return;
        }
        if(nums[n-1] > nums[n-2]) {
            System.out.println(n-1);
            return;
        }

        int start = 1, end = n-2;
        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                System.out.println(mid);
                return;
            }
            else if(nums[mid] > nums[mid-1]) start = mid + 1;
            else end = mid - 1;
        }

        return;
    }
}