import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1937 {
	static int N;
	static int [][] forest;
	static int [][] dp; //경로 테이블
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		forest = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				forest[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				result = Math.max(result, dfs(i,j));
			}
		}
		System.out.println(result);
	}
	static int dfs(int i,int j) {
		if(dp[i][j] != 0) { //이미 지나간곳 (계산완료)
			return dp[i][j];
		}
		dp[i][j] = 1;
		int [][] next = {{-1,0},{1,0},{0,1},{0,-1}};
		for(int k=0;k<4;k++) { //4방 탐색
			int nextI = i+next[k][0];
			int nextJ = j+next[k][1];
			if(nextI == 0 || nextI>N) continue; //i조건
			if(nextJ == 0 || nextJ>N) continue; //j조건
			if(forest[i][j] >= forest[nextI][nextJ]) continue; // 다음 장소가 나무가 더 적은경우
			dp[i][j] = Math.max(dp[i][j], dfs(nextI,nextJ)+1); // 지금 장소 = 다음장소 +1 개만큼 갈수있음
		}
		return dp[i][j];
	}
}
