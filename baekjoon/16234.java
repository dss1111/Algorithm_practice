import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16234 {
		static int[][] map;
		static int[][] group; // 나라의 연합표 
		static int N,L,R;
		static int groupNum; // 연합번호
		static int groupSize; // 연합의 나라 수 
		static int sum; // 연합의 인구수 
		static int day; // 일 
		static int [][]nextDir = {{0,1},{0,-1},{1,0},{-1,0}}; 
		static List <Integer> population;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			getResult();
			System.out.println(day);
		}
		public static void getResult() {
			do { 
				group = new int[N][N]; //하루마다 연합현황 초기화
				groupNum = 0; //시작연합은 0번 
				population = new ArrayList <>(); // population.get(i)  = i 번째 연합의 인구변화결과
				population.add(0);
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(group[i][j]!=0) continue; //이미 그룹이 있음 pass
						checkOpen(i,j);
					}
				}
				if(groupNum == N*N) break; // 연합의 수가 전체 나라의 수와 같으면 이동이 없음
				move(); // 연합이 있으므로 이동
				day++; // 날짜 하루 증가
			} while(true);
		}
		public static void checkOpen(int r, int c) {
			Queue <int[]> q = new LinkedList<>();
			q.add(new int[] {r,c});
			groupNum++; // 연합번호 증가. 번호 1부터 시작하게 됨 
			sum = 0; // 연합의 인구수 총합
			groupSize = 0; // 연합에 속한 나라 수
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int nowI = now[0];
				int nowJ = now[1];
				if(group[nowI][nowJ]!= 0) continue;
				group[nowI][nowJ]=groupNum; // 방문하면 같은 연합번호
				groupSize++; // 연합 속한 나라 수 증가 
				sum += map[nowI][nowJ];
				for(int k=0;k<4;k++) {
					int nextI = nowI + nextDir[k][0];
					int nextJ = nowJ + nextDir[k][1];
					if(nextI < 0 || nextI >= N || nextJ <0 || nextJ >=N) continue; // 범위 밖 
					if(group[nextI][nextJ] != 0) continue; // 이미 연합이 있음.
					int diff = Math.abs(map[nowI][nowJ]-map[nextI][nextJ]); // 절대값 계산
					if(diff >= L && diff <= R) q.add(new int[] {nextI,nextJ}); // 탐색
				}
			}
			population.add(sum/groupSize);
		}
		public static void move() {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = population.get(group[i][j]); // 자기그룹의 인구로 만들어줌
				}
			}
		}
}
