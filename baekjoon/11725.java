import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11725 {
	static int N;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static boolean [] visit;
	static int [] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		parent = new int[N+1];
		for(int n=0;n<=N;n++) {
			list.add(new ArrayList<Integer>());
		}
		for(int n=1;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		makeTree(1);
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<N+1;i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void makeTree(int index) {
		visit[index] = true;
		for(int v : list.get(index)) {
			if(visit[v]) continue;
			parent[v] = index;
			makeTree(v);
		}
	}
}
