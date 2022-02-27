import java.util.*;

public class Main {
    static int MAX = 10000;
    static int N, M;
    static int start, destination;
    
    static long[][] bridge = new long[MAX][MAX];
    static long[] visit = new long[MAX];
    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int island1 = sc.nextInt();
            int island2 = sc.nextInt();
            long kg = sc.nextInt();
            
            if (bridge[island1-1][island2-1] == 0 
                || (bridge[island1-1][island2-1] > 0 &&
                    kg > bridge[island1-1][island2-1]
                ))
            {
                bridge[island1-1][island2-1] = kg;
                bridge[island2-1][island1-1] = kg;
            }
        }

        start = sc.nextInt();
        destination = sc.nextInt();
    }
    
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start-1);
        
        while(!queue.isEmpty()) {
            int node = queue.poll();

            if (node == destination-1) {
                System.out.println(visit[destination-1]);
                break;
            }

            for (int i = 0; i < bridge[node].length; i++) {
                if (bridge[node][i] > 0 && visit[i] == 0) {
                    queue.add(i);
                    visit[i] = visit[node] + bridge[node][i];
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
    }
}