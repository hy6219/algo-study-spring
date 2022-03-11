package datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class boj17298 {
    /**
     * 1.끝~i까지 스택에 넣기
     * 2.1개만 pop 해서 변수에 담아두기 -a
     * 3.a보다 큰 값 나오면, nge로 기록
     * 스택이 빌때까지 진행했는데오 없으면 -1을 nge로 기록
     * 4.1~3을 반복
     */
    static Scanner scanner;
    static int N;
    static int[] numbers;
    static Stack<Integer> stack;
    static int[] nge;
    static StringBuilder sb;

    static void input(){
        scanner = new Scanner(System.in);
        sb = new StringBuilder();
        N= scanner.nextInt();

        numbers = new int[N];
        nge = new int[N];

        for(int i = 0 ; i < N; i++){
            numbers[i] = scanner.nextInt();
        }

    }

    /**
     * N-1~i까지 스택에 넣기
     */
    static void pushToStack(int ord){
        stack = new Stack<>();

        for(int i = N-1 ; i >=ord; i--){
            stack.push(numbers[i]);
        }
    }

    /**
     * nge기록
     */
    static void recordNge(){
        for(int i = 0 ; i < N; i++){
            //스택에 넣기
            pushToStack(i);
            //1개 pop 해서 비교
            popAndCompare(i);
        }

        for(int i = 0 ; i < nge.length; i++){
            sb.append(nge[i]).append(' ');
        }

        System.out.println(sb);
    }

    static void popAndCompare(int idx){
        if(stack.size() == 0) return;

        int popped = stack.pop();

        while(!stack.isEmpty()){
            int next = stack.pop();

            //popped보다 크면 기록
            if(next > popped){
                nge[idx] = next;
                return;
            }
        }

        //끝까지 안나오면 -1 기록
        nge[idx] = -1;
    }

    static void pro(){
        input();
        recordNge();
    }

    public static void main(String[] args) {
        pro();
    }
}
