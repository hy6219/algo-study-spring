import java.util.Stack;

class Pairs {

	int x;
	int y;

	Pairs(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class LandCount_DFS_solution2 {

	static int[][] arr;
	static int[][] check;
	static int dx = {-1, 1, 0, 0};
	static int dy = {0, 0, -1, 1}; 
	static int w1;
	static int h1;

	private static void dfs(int x, int y, int count){
		Stack<Pairs> stack = new Stack<>();
		Pairs p = new Pairs(x, y);
		boolean flag = false;
		stack.push(p);
		check[x][y] = count;
		
		while(!stack.isEmpty()){
			Pairs peek = stack.peek();
			flag = false;
			x = peek.x;
			y = peek.y;

			for(int i=0; i<dx.length; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < h1 && 0 <= ny && ny < w1){
					if(arr[nx][ny] == 0 && check[nx][ny] == 0){
						stack.push(new Pairs(nx, ny);
						check[nx][ny] = count;
						flag = true;
						break;
					}
				}
			}
			if(!flag){
				stack.pop();
			}
		
		}
	}
	
	public static int solution(int [][]data){
		int count = 0;
		arr = data;
		h1 = data.length;
		w1 = data[0].length;
		check = new int[h1][w1];

		for(int i=0; i<h1; i++){
			for(int j=0; j<w1; j++){
				if(arr[i][j] == 0 && check[i][j] == 0){
					dfs(i, j, ++count);
				}
			}
		}

		return count;
	}

	public static void main(String[] args){

		int [][]data = {{1, 0, 1, 0, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 1, 1}}
		int count = solution(data);

	}
	
}
