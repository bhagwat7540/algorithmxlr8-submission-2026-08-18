import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int q = sc.nextInt();

        // Write your solution here.
        // Maintain a size-k min-heap seeded with nums, then for each of the
        // q add(val) calls, print the resulting kth largest value.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);

            if(pq.size() > k) pq.poll();
        }

        for(int i=0 ; i<q ; i++) {
            int x = sc.nextInt();

            pq.add(x);
            if(pq.size() > k) pq.poll();
            System.out.println(pq.peek());
        }
        
    }
}
