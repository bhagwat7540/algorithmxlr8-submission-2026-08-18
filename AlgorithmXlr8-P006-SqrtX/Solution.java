import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();

        // Write your solution here.
        // Print the square root of x, rounded down to the nearest integer.
        long start = 1, end = x;

        while(start <= end) {
            long mid = start + (end - start)/2;
            if(mid*mid == x) {
                System.out.println(mid);
                return;
            }
            else if(mid*mid < x) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
        return;
    }
}
