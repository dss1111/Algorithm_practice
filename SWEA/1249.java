import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static final int INF = 987654321;
	static int SIZE;
	static int[][] map;
	static int[][] cost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			SIZE = Integer.parseInt(br.readLine());
			map = new int[SIZE][SIZE];
			cost = new int[SIZE][SIZE];
			for(int i=0;i<SIZE;i++) {
				String s = br.readLine();
				for(int j=0;j<SIZE;j++) {
					map[i][j] = Integer.parseInt(s.substring(j, j+1));
					cost[i][j] = 987654321;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(getResult());
			System.out.println(sb);
		}
	}
	static int getResult() {
		Queue <int[]>q = new ArrayDeque<>();
		q.add(new int[] {0,0,0});
		while(!q.isEmpty()){
			int[] now = q.poll();
			int nowI = now[0];
			int nowJ = now[1];
			int nowV = now[2];
			if(cost[nowI][nowJ]<=nowV)continue;
			cost[nowI][nowJ]=nowV;
			if(nowJ<SIZE-1) { //오른쪽
				q.add(new int[] {nowI,nowJ+1,nowV+map[nowI][nowJ+1]});
			}
			if(nowI<SIZE-1) { //아래쪽
				q.add(new int[] {nowI+1,nowJ,nowV+map[nowI+1][nowJ]});
			}
			if(nowI>0) { //위쪽
				q.add(new int[] {nowI-1,nowJ,nowV+map[nowI-1][nowJ]});
			}
			if(nowJ>0) {//왼쪽
				q.add(new int[] {nowI,nowJ-1,nowV+map[nowI][nowJ-1]});
			}
		}
		return cost[SIZE-1][SIZE-1];
	}
}
