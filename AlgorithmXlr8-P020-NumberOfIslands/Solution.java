import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[][] grid = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = 0;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(grid[i][j] == 1) {
                    ans++;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 2;

                    while(!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        int x = tmp[0], y = tmp[1];

                        for(int k=0 ; k<4 ; k++) {
                            int newX = x + dx[k], newY = y + dy[k];
                            if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                                queue.offer(new int[]{newX, newY});
                                grid[newX][newY] = 2;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
