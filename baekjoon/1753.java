import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Node implements Comparable<Node>{
	int end;
	int cost;
	public Node(int end, int cost) {
		this.end=end;
		this.cost=cost;
	}
	public int compareTo(Node n) {
		return cost-n.cost;
	}
}
public class Main {
	static final int INF = 987654321;
	static ArrayList <Node>[] graph;
	static int[] minCost;
	static boolean [] visited;
	static int V,E,S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());
		graph = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			graph[i] = new ArrayList<>();
		}
		minCost = new int[V+1];
		visited = new boolean[V+1];
		Arrays.fill(minCost, INF);
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Node(end,cost));
		}
		getResult();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(minCost[i]==INF)
				sb.append("INF\n");
			else
				sb.append(minCost[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void getResult() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(S,0));
		minCost[S]=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.end;
			if(visited[now] == true) {
				continue;
			}
			visited[now] = true;
			for(Node n: graph[now]) {
				if(minCost[n.end]>minCost[now]+n.cost) {
					minCost[n.end]=minCost[now]+n.cost;
					pq.add(new Node(n.end,minCost[n.end]));
				}
			}
		}
	}
}
