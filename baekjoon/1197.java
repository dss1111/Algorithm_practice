package 최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V,E;
	static int parents[];
	static Edge list [];
	static class Edge implements Comparable<Edge> {
		int from,to,weight;
		
		public Edge(int from,int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		list = new Edge[E];
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[i] = new Edge(from,to,weight);
		}
		Arrays.sort(list);
		make();
		int result = 0;
		int vCount = 0;
		for(int i=0;i<list.length;i++) {
			if(union(list[i].from,list[i].to)) {
				result += list[i].weight;
				vCount++;
				if(vCount==V-1) break;
			}
		}
		System.out.println(result);
	}
	static void make() {
		for(int i=1;i<=V;i++){
			parents[i]=i;
		}
	}
	static int findSet(int v) {
		if(parents[v]==v) return v;
		return parents[v] = findSet(parents[v]);
	}
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
