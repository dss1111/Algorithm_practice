import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1012 {
	static int T;
	static int N,M,K;
	static int[][] board;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			K = Integer.parseInt(st.nextToken());
			for(int k=1;k<=K;k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[y][x] = -1;
			}
			result=0;
			getResult();
			System.out.println(result);
		}
	}
	static void getResult() {
		for(int n=0;n<N;n++) {
			for(int m=0;m<M;m++) {
				if(board[n][m]==-1) {
					result++;
					bfs(n,m);
				}
			}
		}
	}
	static void bfs(int n,int m) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {n,m});
		board[n][m] = result;
		int[][] nextStep = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int k=0;k<4;k++) {
				int nextI = now[0] + nextStep[k][0];
				int nextJ = now[1] + nextStep[k][1];
				if(nextI<0 || nextI>=N) continue;
				if(nextJ<0 || nextJ>=M) continue;
				if(board[nextI][nextJ]!=-1) continue;
				q.add(new int[] {nextI,nextJ});
				board[nextI][nextJ] = result;
			}
		}
	}
}
