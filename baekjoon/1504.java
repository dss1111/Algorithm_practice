import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1504 {
	static int N,E,R;
	static class Edge implements Comparable<Edge>{
		int to;
		int dist;
		Edge(int t,int d){
			to = t;
			dist = d;
		}
		@Override
		public int compareTo(Edge o) {
			return dist - o.dist;
		}
		
	}
	static List<List<Edge>> edges;
	static boolean [] visited;
	static int [] distArr;
	static int visit1,visit2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edges = new ArrayList<>();
		visited = new boolean[N+1];
		distArr = new int[N+1];
		for(int n=0;n<=N;n++) {
			edges.add(new ArrayList<>());
		}
		for(int e=0;e<E;e++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			edges.get(start).add(new Edge(end,dist));
			edges.get(end).add(new Edge(start,dist));
		}
		st = new StringTokenizer(br.readLine());
		visit1 = Integer.parseInt(st.nextToken());
		visit2 = Integer.parseInt(st.nextToken());
		int result1 = 0;
		int result2 = 0;
		int result = 0;
		result1+=getResult(1,visit1);
		result1+=getResult(visit1,visit2);
		result1+=getResult(visit2,N);
		
		result2+=getResult(1,visit2);
		result2+=getResult(visit2,visit1);
		result2+=getResult(visit1,N);
		if(result1 >= 200000000 && result2 >= 200000000) {
			result = -1;
		} else {
			result = Math.min(result1, result2);
		}
		System.out.println(result);	
		
	}
	public static int getResult(int start,int end) {
		Arrays.fill(visited, false);
		Arrays.fill(distArr, 200000000);
		distArr[start] = 0;
		PriorityQueue <Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowLoc = now.to;
			if(visited[nowLoc]) continue;
			visited[nowLoc] = true;
			for(Edge e : edges.get(nowLoc)) {
				if(visited[e.to]) continue;
				if(distArr[e.to]>distArr[nowLoc]+e.dist) {
					distArr[e.to] = distArr[nowLoc]+e.dist;
					pq.add(new Edge(e.to,distArr[e.to]));
				}
			}
		}
		return distArr[end];
	}
}
