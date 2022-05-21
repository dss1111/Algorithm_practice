import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj11724 {
	static List<Integer>[] graph;
	static boolean visited[];
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		int result = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		for(int i = 1;i < N+1; i++) {
			if(!visited[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}
	public static void dfs(int v){
        if(visited[v]) {
            return;
        }
        visited[v]=true;
        for(int i : graph[v]){
            if(!visited[i]) {
                dfs(i);
            }
        }
	}
}
