import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2252 {
		static int N,M; 
		static ArrayList<ArrayList<Integer>> list; // 인접 리스트
		static int [] edgeCount;
		static StringBuffer sb;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			edgeCount = new int[N+1];
			list = new ArrayList<>();
			for(int n=0;n<=N;n++) {
				list.add(new ArrayList<>()); 
			}
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list.get(from).add(to); // 시작점 -> 도착점 edge
				edgeCount[to]++; // 도착점 간선수 ++
			}
			sb = new StringBuffer();
			// 위상정렬
			// 차수가 0인경우 (다른 노드에서 오는 간선이 없는경우)
			Queue<Integer> q = new LinkedList<>();
			for(int i=1;i<=N;i++) {
				if(edgeCount[i]==0) { // 차수가 0
					q.add(i);
				}
			}
			while(!q.isEmpty()) {
				Integer node = q.poll();
				sb.append(node).append(" "); // 꺼냈으니 추가 
				ArrayList<Integer> next = list.get(node); // 이 노드에서 출발하는 간선탐색
				for(Integer e : next) {
					edgeCount[e]--; // 해당 노드의 차수--
					if(edgeCount[e] == 0) { // 차수가 0이면
						q.add(e);
					}
				}
			}
			System.out.println(sb);
		}
}
