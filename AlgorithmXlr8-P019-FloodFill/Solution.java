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

        int row = sc.nextInt(), col = sc.nextInt();
        int color = sc.nextInt();

        int iniColor = grid[row][col];
        if(iniColor == color) {
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<m ; j++) {
                    System.out.print(grid[i][j]);
                    if(j != m-1) System.out.print(" ");
                }

                System.out.println();
            }

            return; 
        }

        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = color;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1];

            for(int k=0 ; k<4 ; k++) {
                int newR = r + dx[k];
                int newC = c + dy[k];

                if(newR >= 0 && newR <n && newC >=0 && newC < m && grid[newR][newC] == iniColor) {
                    queue.offer(new int[]{newR, newC});
                    grid[newR][newC] = color;
                }
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                System.out.print(grid[i][j]);
                if(j != m-1) System.out.print(" ");
            }

            System.out.println();
        } 
    }
}