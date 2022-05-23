import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1238{
	static int N,M,X;
	static List <List<Node>> road;
	static List <List<Node>> reverse_road;
	static int[] dist,reverse_dist;
	static class Node implements Comparable<Node>{
		int index;
		int dist;
		public Node(int i, int d) {
			index = i;
			dist = d;
		}
		public int compareTo(Node node) {
			return this.dist - node.dist;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		road = new ArrayList<>();
		reverse_road = new ArrayList<>();
		for(int n=0;n<=N;n++) {
			road.add(new ArrayList<>());
			reverse_road.add(new ArrayList<>());
		}
		
		dist = new int[N+1];
		reverse_dist = new int[N+1];
		Arrays.fill(dist, 987654321);
		Arrays.fill(reverse_dist, 987654321);
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			road.get(start).add(new Node(end,cost));
			reverse_road.get(end).add(new Node(start,cost));
		}
		getRoad(road, dist);
		getRoad(reverse_road,reverse_dist);
		int result = -1;
		for(int i=1;i<=N;i++) {
			result = Math.max(dist[i]+reverse_dist[i], result);
		}
		System.out.println(result);
	}
	public static void getRoad(List<List<Node>> list , int[] d) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node>pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		d[X] = 0;
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			if(visited[now]) continue;
			visited[now] = true;
			for(Node node: list.get(now)) {
				if(d[node.index] > d[now]+node.dist) {
					d[node.index] = d[now]+node.dist;
					pq.add(new Node(node.index, d[node.index]));
				}
			}
		}
	}
}
