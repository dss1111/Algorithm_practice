import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj11779 {
	static int N,M,cityCount;
	static boolean [] visit;
	static int[] minDist,track;
	static class Edge implements Comparable<Edge>{
		int end;
		int weight;
		Edge(int e,int w){
			end = e;
			weight = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
		
	}
	static ArrayList<ArrayList<Edge>> vertex = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		for(int n=0;n<=N;n++) {
			vertex.add(new ArrayList<Edge>()); //각 도시의 버스노선 리스트초기화
		}
		for(int m=0;m<M;m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			vertex.get(start).add(new Edge(end,weight)); //각 도시의 버스노선 add
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		minDist = new int[N+1];
		Arrays.fill(minDist, 987654321); // 다익스트라 초기값 INF
		track = new int[N+1];
		bfs(start); //bfs
		ArrayDeque <Integer>dq = new ArrayDeque<>();
		int now = end;
		while(now!=start) {
			cityCount++;
			dq.addFirst(now);
			now = track[now];
		}
		dq.addFirst(now);
		cityCount++;
		// 시작 - 중간도시1 - 중간도시2 - ... - 도착
		
		StringBuilder sb = new StringBuilder();
		sb.append(minDist[end]).append("\n").append(cityCount).append("\n");
		while(!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(" ");
		}
		System.out.println(sb);
	}
	static void bfs(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		minDist[start] = 0;
		pq.add(new Edge(start, 0));
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visit[now.end]) continue; // 이미방문
			
			visit[now.end]=true; //방문처리
			for(Edge edge : vertex.get(now.end)) { //도시내의 버스리스트
				if(minDist[edge.end] > minDist[now.end] + edge.weight) { //현재도시까지 최소비용 > 이전도시까지 비용 + 버스비용  
					minDist[edge.end] = minDist[now.end] + edge.weight; //갱신
					pq.add(new Edge(edge.end,minDist[edge.end])); //다음경로 현재도시
					track[edge.end] = now.end; //도시 경로저장용
				}
			}
		}
	}
}
