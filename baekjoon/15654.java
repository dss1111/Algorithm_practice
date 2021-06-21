import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15654 {
	static int N,M;
	static int [] arr;
	static int [] result;
	static boolean [] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}
	static void dfs(int level) {
		if(level == M) {
			for(int i = 0;i<M;i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			visit[i]=true;
			result[level] = arr[i];
			dfs(level + 1);
			visit[i]=false;
		}
	}
}
