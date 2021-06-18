import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1325 {
	static int N,M,max;
	static boolean [] visit;
	static int [] visitCount;
	static int [] counts;
	static ArrayList<Integer>[] edge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new ArrayList[N+1];
		visitCount=new int[N+1];
		for(int n=0;n<=N;n++) {
			edge[n] = new ArrayList<>();
		}
		counts= new int[N+1];
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			edge[start].add(end);
		}
		for(int n=1;n<=N;n++) {
			visit = new boolean[N+1];
			dfs(n, 0);
		}

		for(int n=1;n<=N;n++) {
			max = Math.max(max, visitCount[n]);
		}
		StringBuilder sb = new StringBuilder();
		for(int n=1;n<=N;n++) {
			if(max == visitCount[n]){
				sb.append(n).append(" ");
			}
		}
		System.out.println(sb);
	}
	static void dfs(int start, int count) {
		visit[start] = true;
		for(int next : edge[start]) {
			if(visit[next]) continue;
			visitCount[next]++;
			dfs(next,count+1); 
		}
	}
}
