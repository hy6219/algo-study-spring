import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Integer> s = new Stack<>();
    static int[] arr;
    static int[] answer;
    static int N;

    static void getNGE() {
        answer = new int[N];
        for (int i = N-1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= arr[i]) {
                s.pop();
            }

            if (s.empty()) answer[i] = -1;
            else answer[i] = s.peek();

            s.push(arr[i]);
        }
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int su = sc.nextInt();
            arr[i] = su;
        }
    }
    public static void main(String[] args) {
        input();
        getNGE();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.print(sb);
    }
}