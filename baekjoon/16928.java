import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16928 {
	static int [] board = new int [101]; //최소횟수 저장
	static HashMap<Integer,Integer> map; //사다리,뱀 출발지 도착지 저장
	static int N,M;
	static Queue<int[]> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		for(int i=0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map.put(start, end); //get(출발지) = 도착지
		}
		Arrays.fill(board, 150);
		getResult();
		System.out.println(board[100]);
	}
	public static void getResult() {
		q = new ArrayDeque<>();
		board[1] = 0;
		q.add(new int[] {1,0});
		while(!q.isEmpty()) {
			int [] now = q.poll();
			int nowLoc = now[0];
			int nowCount = now[1];
			if(map.containsKey(nowLoc)){ // 사다리 or 뱀
				if(board[map.get(nowLoc)]>nowCount) { // 최소갱신
					q.add(new int[] {map.get(nowLoc),nowCount});
					board[map.get(nowLoc)] = nowCount;
				}
			} else {
				for(int i=1;i<=6;i++) { // 주사위
					if(nowLoc + i <= 100) {
						if(board[nowLoc + i]>nowCount+1) { //최소갱신
							q.add(new int[] {nowLoc + i,nowCount+1});
							board[nowLoc + i] = nowCount+1;
						}
					}
				}
			}
		}
	}
}
