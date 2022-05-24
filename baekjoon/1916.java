import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1916 {
	static int N,M;
	static List<List<Node>> bus;
	static class Node implements Comparable<Node>{
		int index;
		int dist;
		Node(int i,int d){
			index = i;
			dist = d;
		}
		@Override
		public int compareTo(Node n) {
			return this.dist - n.dist;
		}
		
	}
	static int S,E;
	static int [] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		bus = new ArrayList<>();
		for(int n=0;n<=N;n++) {
			bus.add(new ArrayList<>());
		}
		d = new int[N+1];
		Arrays.fill(d, 987654321);
		for(int m=0;m<M;m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			bus.get(start).add(new Node(end,dist));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		getResult();
		System.out.println(d[E]);
	}
	public static void getResult() {
		PriorityQueue <Node> pq = new PriorityQueue<>();
		pq.add(new Node(S,0));
		d[S] = 0;
		boolean [] visited = new boolean[N+1]; 
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			if(visited[now]) continue;
			visited[now] = true;
			for(Node node : bus.get(now)){
				if(d[node.index] > d[now]+node.dist) {
					d[node.index] = d[now]+node.dist;
					pq.add(new Node(node.index, d[node.index]));
				}
			}
		}
	}
}
