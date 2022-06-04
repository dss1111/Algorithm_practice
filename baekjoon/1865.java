import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj1865 {
		static int TC,N,M,W;
		static int [] numbers;
		static int [] result;
		static StringBuffer sb;
		static class Road{ // 생각해보니 웜홀과 길은 time만 음수, 양수 차이라서 클래스하나로 처리
			int end;
			int time;
			Road(int end, int time){
				this.end = end;
				this.time = time;
			}
		}
		static List<List <Road>> roadList;
		static int [] distArr;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			TC = Integer.parseInt(st.nextToken());
			StringBuffer sb = new StringBuffer();
			for(int tc=1;tc<=TC;tc++) {
				st = new StringTokenizer(br.readLine());
				roadList = new ArrayList<>();
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				W = Integer.parseInt(st.nextToken());
				distArr = new int[N+1];
				for(int n=0;n<=N;n++) {
					roadList.add(new ArrayList<>());
				}
				for(int m=0;m<M;m++) {
					st = new StringTokenizer(br.readLine());
					int start = Integer.parseInt(st.nextToken());
					int end = Integer.parseInt(st.nextToken());
					int time = Integer.parseInt(st.nextToken());
					roadList.get(start).add(new Road(end,time));
					roadList.get(end).add(new Road(start,time));
				}
				for(int w=0;w<W;w++) {
					st = new StringTokenizer(br.readLine());
					int start = Integer.parseInt(st.nextToken());
					int end = Integer.parseInt(st.nextToken());
					int time = Integer.parseInt(st.nextToken());
					roadList.get(start).add(new Road(end,time * -1));
				}
				boolean isYes = false; // 자신으로 돌아오는 거리가 음수인 경우 체크
				for(int n=1; n<=N;n++) {
					if(getResult(n)) {
						isYes = true;
						break;
					}
				}
				if(isYes) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
			System.out.println(sb);
		}
		public static boolean getResult(int startLoc) {
			Arrays.fill(distArr, 987654321); // 거리 Max
			distArr[startLoc] = 0; // 시작점 0
			for(int i=1;i<N;i++) {
				boolean check = false; // 체크안하면 시간초과, 정점 전체에서 갱신이 없으면 건너뛰기 위함
				for(int j=1;j<=N;j++) {
					for(Road r : roadList.get(j)) {
						if(distArr[j] == 987654321) continue;
						if(distArr[r.end] > distArr[j] + r.time ) {
							distArr[r.end] = distArr[j] + r.time;
							check = true;
						}
					}
				}
				if(check == false) {
					break;
				}
			}
			if(distArr[startLoc] < 0) return true;
			return false;
		}
}
