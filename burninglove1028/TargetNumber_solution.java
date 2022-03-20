class TargetNumber{

	static int targetValue;
	static int []arr;
	static int cnt;
	static int N;

	public void dfs(int idx, int value){
		if(idx==N && targetValue==value){
			cnt++;
			return;
		}
		if(idx==N){
			return;
		}

		dfs(idx+1, value+arr[idx]);
		dfs(idx+1, value-arr[idx]);

	}

	public int solution(int []numbers, int target){
		int result=0;
		targetValue = target;
		arr=numbers;
		N=numbers.length;

		dfs(0, 0)

		result=cnt;
	
		return result;
	}

}

public class TargetNumber_solution {

	public static void main(String args){
		int []numbers = {1, 1, 1, 1, 1};
		int target = 3;

		TargetNumber tn = new TargetNumber();
		int res = tn.solution(numbers, target);
		System.out.println(res);
	}
}
