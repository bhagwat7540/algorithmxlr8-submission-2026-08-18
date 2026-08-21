import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) stones[i] = sc.nextInt();

        // Write your solution here.
        // Print the weight of the last remaining stone, or 0.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones) pq.add(stone);

        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if(first != second) {
                pq.add(Math.abs(first - second));
            }
        }

        int ans = pq.isEmpty() ? 0 : pq.poll();
        System.out.println(ans);
    }
}
