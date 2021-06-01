import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {
	static int N,M;
	static char[][] arr;
	static boolean [][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];
		for(int n=0;n<N;n++) {
			String str = br.readLine();
			arr[n] = str.toCharArray();
		}
		System.out.println(bfs());
	}
	static int bfs(){
		Queue <int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,1});
		int[][] nextStep = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowI = now[0];
			int nowJ = now[1];
			int step = now[2];
			if(nowI==N-1 && nowJ==M-1) {
				return step;
			}
			visit[nowI][nowJ]=true;
			for(int k=0;k<4;k++) {
				int nextI = nowI + nextStep[k][0];
				int nextJ = nowJ + nextStep[k][1];
				if(nextI<0 || nextI>=N) continue;
				if(nextJ<0 || nextJ>=M) continue;
				if(visit[nextI][nextJ] || arr[nextI][nextJ]=='0') continue;
				q.add(new int[] {nextI,nextJ,step+1});
				visit[nextI][nextJ]=true;
			}
		}
		return 0;
	}
}
