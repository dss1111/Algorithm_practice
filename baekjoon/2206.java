import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2206 {
	static int N,M;
	static char [][]map ;
	static class Loc{
		int i,j;
		int count;
		boolean isBroken;
		Loc(int i,int j,int count,boolean isBroken){
			this.i = i;
			this.j = j;
			this.count = count;
			this.isBroken = isBroken;
		}
	}
	static Queue<Loc> q ;
	static boolean [][][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[2][N][M]; // 0 = 벽안부순경우 1 = 벽 부순경
		for(int n=0;n<N;n++) {
			map[n] = br.readLine().toCharArray();
		}
		q = new ArrayDeque<>();
		getResult();
	}
	public static void getResult() {
		q.add(new Loc(0,0,1,false));
		while(!q.isEmpty()) {
			Loc now = q.poll();
			if(now.i == N-1 && now.j== M-1) {
				System.out.println(now.count);
				return;
			}
			int [][] next = {{1,0},{0,1},{-1,0},{0,-1}};
			for(int k=0;k<4;k++) {
				int nextI = now.i + next[k][0];
				int nextJ = now.j + next[k][1];
				if(nextI<0 || nextI >=N || nextJ<0 || nextJ>=M) continue;
				if(map[nextI][nextJ]=='0') { //벽이아님
					if(!now.isBroken && !visited[0][nextI][nextJ]) { // 벽부순적 없고 미방문
						q.add(new Loc(nextI,nextJ,now.count+1,false));
						visited[0][nextI][nextJ] =true;
					} else if(now.isBroken && !visited[1][nextI][nextJ]){ // 벽부순적 있는데 미방문
						q.add(new Loc(nextI,nextJ,now.count+1,true));
						visited[1][nextI][nextJ] =true;
					}
				} else {// 벽
					if(!now.isBroken) { //벽 부술수 있음
						q.add(new Loc(nextI,nextJ,now.count+1,true));
						visited[1][nextI][nextJ]=true;
					}
				}
			}
		}
		System.out.println("-1");
	}
}
