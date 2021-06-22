import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj12851 {
	static int N,K;
	static int resultWay;
	static int [] visit = new int[100001]; //해당 위치에 도달한 최소시간
	static class Node implements Comparable<Node>{
		int time;
		int loc;
		Node(int t,int l){
			time = t;
			loc = l;
		}
		@Override
		public int compareTo(Node o) {
			return time - o.time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(visit, 987654321);
		bfs();
		System.out.println(visit[K]);
		System.out.println(resultWay);
	}
	static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>(); //시간순 정렬
		pq.add(new Node(0,N));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int loc = now.loc;
			int time = now.time;
			visit[loc]=Math.min(visit[loc], time); //최소시간 갱신
			if(loc == K && visit[K]==time) {
				resultWay++;
			}
			if(visit[loc]<time) continue; //이미 현재위치에 도달하는 더 빠른 방법이 있음 고려대상 제외
			if(time > visit[K]) break; //목적지에 도달하는 시간이 더 빠름 고려대상 제외
			if(loc-1 >=0 && loc-1<=100000) { // -1
				pq.add(new Node(time+1,loc-1));
			}
			if(loc+1 >=0 && loc+1<=100000) { // +1
				pq.add(new Node(time+1,loc+1));
			}
			if(loc*2 >=0 && loc*2<=100000) { // *2
				pq.add(new Node(time+1,loc*2));
			}
		}
	}
}
