import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> wh = new HashMap<>();
        Map<String, Integer> re = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            re.put(id_list[i], 0);
        }

        for (int i = 0; i < report.length; i++) {
            String[] r = report[i].split(" ");
            if (wh.get(r[0]) == null) {
                Set<String> set = new HashSet<String>();
                set.add(r[1]);
                wh.put(r[0], set);
            } else {
                Set<String> set = wh.get(r[0]);
                set.add(r[1]);
                wh.put(r[0], set);
            }
        }

        for (Set<String> s: wh.values()) {
            Iterator<String> it = s.iterator();
            while(it.hasNext()) {
                String name = it.next();
                re.put(name, re.get(name) + 1);
            }
        }

        for (String key : re.keySet()) {
            if (re.get(key) >= k) {
                for (String ke: wh.keySet()) {
                    Set<String> v = wh.get(ke);
                    if (v.contains(key)) {
                        answer[Arrays.asList(id_list).indexOf(ke)] += 1;
                    }
                }
            }
        }        
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}; 
        solution.solution(id_list, report , 2);
        
    }
}