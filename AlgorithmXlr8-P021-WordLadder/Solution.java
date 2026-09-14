import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your solution here.
        Scanner sc = new Scanner(System.in);
        String beginWord = sc.next();
        String endWord = sc.next();
        int n = sc.nextInt();

        Set<String> set = new HashSet<>();
        for(int i=0 ; i<n ; i++) {
            set.add(sc.next());
        }

        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!queue.isEmpty()) {
            Pair tmp = queue.poll();
            char[] arr = tmp.first.toCharArray();
            int lvl = tmp.second;

            for(int i=0 ; i<arr.length ; i++) {
                char original = arr[i];
                for(char ch='a' ; ch<='z' ; ch++) {
                    if(ch != original) {
                        arr[i] = ch;
                        String s = new String(arr);
                        if(set.contains(s)) {
                            if(s.equals(endWord)) {
                                System.out.println(lvl+1);
                                return;
                            }
                            queue.offer(new Pair(s, lvl+1));
                            set.remove(s);
                        }
                    }
                }

                arr[i] = original;
            }
        }

        System.out.println(0);
    }

    private static class Pair{
        String first;
        int second;

        public Pair (String first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
