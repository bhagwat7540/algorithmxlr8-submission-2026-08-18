import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().trim().split("\\s+");

        if(arr.length == 0) {
            System.out.println(0);
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);

        for(int i=1 ; i<arr.length ; i++) {
            TreeNode parent = queue.poll();
            if(!arr[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(parent.left);
            }
            i++;

            if(!arr[i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(parent.right);
            }
        }

        int depth = solve(root);
        System.out.println(depth);
    }

    private static int solve(TreeNode node) {
        if(node == null) return 0;

        return 1 + Math.max(solve(node.left), solve(node.right));
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
