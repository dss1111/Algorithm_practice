import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2468 {
	static int N;
	static int [][] arr;
	static boolean [][] visited;
	static int maxH,minH,maxArea;
	static int [][] nextLoc = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		maxH = 0;
		minH = 100;
		maxArea = 1;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int now =Integer.parseInt(st.nextToken());
				arr[i][j] = now;
				maxH = Math.max(maxH, now);
				minH = Math.min(minH, now);
			}
		}
		for(int h = minH; h<=maxH;h++) {
			maxArea = Math.max(getResult(h),maxArea);
		}
		System.out.println(maxArea);
	}
	static int getResult(int h) {
		int area = 0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]) continue;
				if(arr[i][j] <= h) {
					visited[i][j] = true;
					continue;
				}
				area++;
				Queue<int []> q = new LinkedList<>();
				q.add(new int[] {i,j});
				while(!q.isEmpty()) {
					int [] now = q.poll();
					int nowY = now[0];
					int nowX = now[1];
					visited[nowY][nowX] = true;
					for(int k=0;k<4;k++) {
						int nextY = nextLoc[k][0]+nowY;
						int nextX = nextLoc[k][1]+nowX;
						if(nextY < 0 || nextY >= N) continue;
						if(nextX <0 || nextX >= N) continue;
						if(visited[nextY][nextX]) continue;
						if(arr[nextY][nextX] > h) {
							visited[nextY][nextX] = true;
							q.add(new int[] {nextY,nextX});
						}
					}
				}
			}
		}
		return area;
	}
}
