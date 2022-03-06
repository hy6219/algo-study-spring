import java.util.*;

public class Main {
    static int sum(String ns) {
        if (ns.contains("+")) {
            String[] n = ns.split("\\+");
            int s = 0;
            for (int i = 0; i < n.length; i++) {
                if (!n[i].equals("+")) {
                    s += Integer.parseInt(n[i]);
                }
            }
            return s;
        }
        return Integer.parseInt(ns);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] ns = s.split("\\-");
        
        int answer = Integer.parseInt(ns[0]);
        for (int i = 1; i < ns.length; i++) {
            answer -= sum(ns[i]);
        }

        System.out.print(answer);
    }
}