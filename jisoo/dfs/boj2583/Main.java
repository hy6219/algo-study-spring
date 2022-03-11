package dfs.boj2583;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static int M, N, K;
    static int[][] map;//좌표들
    static boolean[][] visited;//방문처리
    static int area;//영역수 카운트
    static int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    static StringBuilder sb;

    static void pro() {
        scanner = new Scanner(System.in);
        sb = new StringBuilder();

        M = scanner.nextInt();
        N = scanner.nextInt();
        K = scanner.nextInt();

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            //열
            int y1 = scanner.nextInt();
            //행
            int x1 = scanner.nextInt();
            //열
            int y2 = scanner.nextInt();
            //행
            int x2 = scanner.nextInt();


            //visit 처리
            rectangularVisitChk(x1, y1, x2, y2);
        }

        //dfs(모든 좌표에서 시작)

        //area값이 들어갈 것
        List<Integer> areaList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                //방문안한곳만 취급!
                if(visited[i][j]) continue;
                //영역처리를 위해서 항상 초기화
                area = 0;
                dfs(i, j);

                if (area > 0) areaList.add(area);
            }
        }

        /*
         *areaList.size: 영역갯수!
         */
        //오름차순정렬!
        Collections.sort(areaList);

        sb.append(areaList.size()).append('\n');

        areaList.forEach(item -> {
            sb.append(item).append(' ');
        });

        System.out.println(sb);
    }

    //직사각형 영역 visit 처리
    static void rectangularVisitChk(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                visited[i][j] = true;
            }
        }
    }

    //dfs
    static void dfs(int curX, int curY) {
        /*
         * 연결된 곳들을 모두 체크하면서 방문안했고 영역안에 있다면 방문처리
         */
        //방문처리
        visited[curX][curY] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            int nextX = curX + dir[i][0];
            int nextY = curY + dir[i][1];

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
            if (visited[nextX][nextY]) continue;

            dfs(nextX, nextY);
        }
    }

    public static void main(String[] args) {
        pro();
    }
}
