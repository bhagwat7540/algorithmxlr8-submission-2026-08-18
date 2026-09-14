import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                int x = sc.nextInt();
                grid[i][j] = x;
                if(x == 2) queue.offer(new int[]{i, j, 0});
            }
        }

        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};

        int ans = 0;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1], time = node[2];
            ans = Math.max(ans, time);

            for(int k=0 ; k<4 ; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                    queue.offer(new int[]{newX, newY, time+1});
                    grid[newX][newY] = 2;
                }
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(grid[i][j] == 1) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);
    }
}