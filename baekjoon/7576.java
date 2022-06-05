import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7576 {
		static int M,N;
		static int [][] box;
		static Queue <Tomato> q;
		static class Tomato {
			int m;
			int n;
			Tomato(int m,int n){
				this.m = m;
				this.n = n;
			}
		}
		static int [][] nextDir = {{0,1},{0,-1},{-1,0},{1,0}}; 
		static int green;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			box = new int[M][N];
			q = new ArrayDeque<>();
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0;m<M;m++) {
					int now = Integer.parseInt(st.nextToken());
					box[m][n] = now;
					if(box[m][n] == 0){
						green++;
					}
					if(box[m][n] == 1) {
						q.add(new Tomato(m,n));
					}
				}
			}
			checkTomato();
			int time = 0;
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(box[m][n] == 0) { 
						System.out.println(-1);
						return;
					}
					time = Math.max(time, box[m][n]);
				}
			}
			if(time ==1)
				System.out.println(0);
			else 
				System.out.println(time-1);
		}
		static void checkTomato() {
			while(!q.isEmpty()) {
				Tomato t = q.poll();
				int nowM = t.m;
				int nowN = t.n;
				for(int k=0;k<4;k++) {
					int nextM = nowM + nextDir[k][0];
					int nextN = nowN + nextDir[k][1];
					if(nextM < 0 || nextM >= M || nextN < 0 || nextN >= N ) continue;
					if(box[nextM][nextN] == 0) {
						box[nextM][nextN] = box[nowM][nowN]+1;
						q.add(new Tomato(nextM,nextN));
					}
				}
			}
		}
}
