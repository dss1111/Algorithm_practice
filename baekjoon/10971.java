import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] graph;
	static boolean [] isSelected;
	static int min=Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		graph = new int[N+1][N+1];
		isSelected = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int count=1;
			while(st.hasMoreTokens()) {
				graph[i][count++]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=N;i++) {
			isSelected[i]=true;
			permutation(1,i,i,0);
			isSelected[i]=false;
		}
		System.out.println(min);
	}
	public static void permutation(int cnt,int now,int start ,int sum) {
		if(cnt==N) {
			if(graph[now][start]!=0)
				min=Math.min(min,sum+graph[now][start]);
			return;
		}
		for(int i=1; i<=N;i++) {
			if(isSelected[i] || graph[now][i]==0) continue;
			isSelected[i] = true;
			//sum+=graph[now][i];
			permutation(cnt+1,i,start,sum+graph[now][i]);
			isSelected[i] = false;
		}
	}
}
