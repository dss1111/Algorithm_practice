import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2589 {
		static int max;
		static boolean [][] visited;
		static char [][] map;
		static int I,J;
		static int [][] nextDir= {{0,1},{1,0},{-1,0},{0,-1}}; 
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			I = Integer.parseInt(st.nextToken());
			J = Integer.parseInt(st.nextToken());
			map = new char[I][J];
			for(int line=0;line<I;line++) {
				map[line] = br.readLine().toCharArray();
			}
			for(int i=0;i<I;i++) {
				for(int j=0;j<J;j++) {
					if(map[i][j]=='W') continue;
					bfs(i,j);
				}
			}
			System.out.println(max);
		}
		public static void bfs(int i,int j) {
			Queue <int[]> q = new ArrayDeque<>();
			visited = new boolean[I][J];
			q.add(new int[] {i,j,0});

			while(!q.isEmpty()) {
				int[] now = q.poll();
				int nowY = now[0];
				int nowX = now[1];
				int nowT = now[2];
				if(visited[nowY][nowX]) continue;
				visited[nowY][nowX] = true;
				max = Math.max(max, nowT);
				for(int k=0;k<4;k++) {
					int nextX = nowX + nextDir[k][0];
					int nextY = nowY + nextDir[k][1];
					if(nextX <0 || nextX >= J || nextY >= I || nextY < 0) continue;
					if(map[nextY][nextX] == 'W') continue;
					if(visited[nextY][nextX]) continue;
					q.add(new int[] {nextY,nextX,nowT+1});
				}
			}
		}
}
