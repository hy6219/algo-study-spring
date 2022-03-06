import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[] val;

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		val = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {			
			val[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(val);
		
		int[] temp = new int[N];
		temp[0] = val[0];
		int ret =0;
		ret += temp[0];
		for(int i =1; i <N; i++) {
			temp[i] += val[i] + temp[i-1];
			ret += temp[i];
		}
		System.out.println(ret);
	}
}
