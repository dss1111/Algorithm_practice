import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj6118 {
	static int N,M;
	static ArrayList<ArrayList<Integer>> barns = new ArrayList<>();
	static int [] dist;
	static int max,firstMax,count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		Arrays.fill(dist, 987654321);
		for(int i=0;i<=N;i++) {
			barns.add(new ArrayList<Integer>());
		}
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			barns.get(a).add(b);
			barns.get(b).add(a);
		}
		bfs();
		StringBuilder sb = new StringBuilder();
		sb.append(firstMax).append(" ").append(max).append(" ").append(count);
		System.out.println(sb);
	}
	static void bfs() {
		Queue <int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,0});
		while(!q.isEmpty()) {
			int [] now = q.poll();
			int depth = now[1];
			if(dist[now[0]]>depth) { //지금 도달한 곳보다
				dist[now[0]] = depth;
			}
			for(int next : barns.get(now[0])) {
				if(dist[next]>depth+1) {
					dist[next]=depth;
					if(max<depth+1) { // 최댓값 갱신
						max = depth+1;
						firstMax = N; //가장 작은 헛간번호를 가장큰값으로 초기화시킴
						count = 0;
					}
					if(max==depth+1) {
						count++;
						firstMax = Math.min(firstMax,next); //헛간번호중 작은 것
					}
					q.add(new int[] {next,depth+1});
				}
			}
		}
	}
}
