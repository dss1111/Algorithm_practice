import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2638 {
	static int N,M;
	static int [][] board;
	static int [][] meltCount;
	static boolean [][] visited;
	static int cheese = 0;
	static int [][] nextDir = {{0,1},{1,0},{-1,0},{0,-1}}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 1) {
					cheese++;
				}
				board[n][m] = now;
			}
		}
		int t = 0;
		while(cheese != 0) {
			visited = new boolean[N][M];
			meltCount = new int[N][M];
			t++;
			meltCounting();
			melt();
		}
		System.out.println(t);
	}
	public static void meltCounting() {
		Queue<int[]> q = new ArrayDeque<>(); 
		q.add(new int[] {0,0}); //가장자리는 0이니 0,0 넣어줌
		while(!q.isEmpty()) { // 큐에는 바깥 0만 들어오게됨
			int [] now = q.poll();
			int nowN = now[0];
			int nowM = now[1];
			if(visited[nowN][nowM]) continue;
			visited[nowN][nowM] = true;
			for(int k=0;k<4;k++) {
				int nextN = nowN+nextDir[k][0];
				int nextM = nowM+nextDir[k][1];
				if(nextN < 0 || nextN >= N || nextM < 0 || nextM >= M) continue;
				if(board[nowN][nowM]==0 && board[nextN][nextM] == 1) meltCount[nextN][nextM]++; //공기와 닿은 치즈에 카운트
				if(!visited[nextN][nextM] && board[nextN][nextM] == 0) q.add(new int[] {nextN,nextM}); // 근처 공기 탐색
			}
		}

	}
	public static void melt() {
		for(int n=0;n<N;n++) {
			for(int m=0;m<M;m++) {
				if(board[n][m] == 0) continue;
				if(meltCount[n][m] >= 2) {
					board[n][m] = 0;
					cheese--;
				}
			}
		}
	}
}
