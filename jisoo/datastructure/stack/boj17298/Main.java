package datastructure.stack.boj17298;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    /**
     * (초기 아이디어)
     * 1.끝~i까지 스택에 넣기
     * 2.1개만 pop 해서 변수에 담아두기 -a
     * 3.a보다 큰 값 나오면, nge로 기록
     * 스택이 빌때까지 진행했는데오 없으면 -1을 nge로 기록
     * 4.1~3을 반복
     *
     * (시간초과 개선)
     * 1.nge -1로 초기화
     * 2.오큰수 발견시 nge[popped] = 현재원소값
     * 3.2 외에는 push push!!
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
        stack = new Stack<>();

        for(int i = 0 ; i < N; i++){
            numbers[i] = scanner.nextInt();
            nge[i] = -1;
        }

    }

    /**
     * nge기록
     */
    static void recordNge(){
        //일단 0번째 넣어두기
        stack.push(0);

        for(int i = 0 ; i < N; i++){
            int cur = numbers[i];

            while(!stack.isEmpty() && numbers[stack.peek()] < cur){
                nge[stack.pop()] = cur;//오큰수 기록(스택에는 인덱스가 기록됨)
            }

            stack.push(i);
        }

        for(int i = 0 ; i < nge.length;i++){
            sb.append(nge[i]).append(' ');
        }
        System.out.println(sb);
    }


    static void pro(){
        input();
        recordNge();
    }

    public static void main(String[] args) {
        pro();
    }
}
