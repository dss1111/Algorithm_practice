import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj14938 {
	static int N,M,R;
	static int [] item; // 각 위치의 아이템수
	static int [] count; // 최대아이템수 카운트
	static class Road implements Comparable<Road>{
		int to;
		int dist;
		Road(int t,int d){
			to = t;
			dist = d;
		}
		@Override
		public int compareTo(Road o) {
			return dist - o.dist;
		}
		
	}
	static List<List<Road>> roads; // 각 위치에서 갈수있는 지역까지의 거리 리스트
	static boolean [] visited;
	static int [] dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		item = new int[N+1];
		count = new int[N+1];
		dist = new int[N+1];
		roads = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<=N;i++) {
			roads.add(new ArrayList<>()); 
		}
		for(int n=1;n<=N;n++) {
			item[n] = Integer.parseInt(st.nextToken());
		}
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			roads.get(from).add(new Road(to,dist));
			roads.get(to).add(new Road(from,dist));//양방향
		}
		int result = 0;
		for(int n=1;n<=N;n++) { //모든지역에서 시작
			drop(n); 
			result = Math.max(result, count[n]);
		}
		System.out.println(result);
	}
	public static void drop(int start) {
		Arrays.fill(dist, 987654321); 
		dist[start] = 0; // 시작지점은 거리 0
		visited = new boolean[N+1];
		PriorityQueue <Road> pq = new PriorityQueue<>();
		pq.add(new Road(start,0));
		while(!pq.isEmpty()) {
			Road now = pq.poll();
			int nowLoc = now.to;
			if(visited[nowLoc]) continue; // 방문한 위치면 패스
			visited[nowLoc] = true; // 방문체크
			for(Road road : roads.get(nowLoc)) { //지금 위치에서 이어진 길 목록
				if(visited[road.to]) continue; //이미 방문한 위치 패스
				if(dist[road.to] > dist[nowLoc] + road.dist) { // 갈곳의 최소 거리 > 지금까지 거리 + 현재지점에서 갈곳까지 거리
					dist[road.to] = dist[nowLoc] + road.dist; // 최소거리 갱신
					pq.add(new Road(road.to,dist[road.to]));
				}
			}
		}
		for(int i=1;i<=N;i++) {
			if(dist[i]<=M) { //제한거리내로 갈 수 있다면 
				count[start] += item[i]; //해당지역 아이템수 더하기
			}
		}
	}
}
