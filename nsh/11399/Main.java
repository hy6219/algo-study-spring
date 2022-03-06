import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);
        int t = 0;
        int sum = 0;
        for (int i = 0; i < p.length; i++) {
            t += p[i];
            sum += t;
        }

        System.out.println(sum);
    }
}