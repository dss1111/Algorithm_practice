import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2096 {
		static int N,Max,Min;
		static int [][] arr;
		static int [][][] dp; //i번째줄 j번째 숫자의 최솟값, 최댓값
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][3];
			dp = new int[N][3][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}
			getResult();
			System.out.println(Max+" "+Min);
		}
		public static void getResult() {
			dp[0][0][0] = arr[0][0];
			dp[0][1][0] = arr[0][1];
			dp[0][2][0] = arr[0][2];
			dp[0][0][1] = arr[0][0];
			dp[0][1][1] = arr[0][1];
			dp[0][2][1] = arr[0][2];
			for(int i=1;i<N;i++) {
				dp[i][0][0] = Math.min(dp[i-1][0][0] , dp[i-1][1][0]) + arr[i][0];
				// 다음 0번째칸의 최솟값 = 이전 0번째칸, 1번째값 최솟값중 작은것 + 현재값 
				dp[i][0][1] = Math.max(dp[i-1][0][1] , dp[i-1][1][1]) + arr[i][0];
				// 다음 0번째칸의 최댓값 = 이전 0번째칸, 1번째값 최댓값중 큰것 + 현재값 
				dp[i][1][0] = Math.min(Math.min(dp[i-1][0][0] , dp[i-1][1][0]),dp[i-1][2][0])+ arr[i][1];
				// 다음 1번째칸의 최솟값 = 이전 0,1,2번째 값 최솟값중 작은것 + 현재
				dp[i][1][1] = Math.max(Math.max(dp[i-1][0][1] , dp[i-1][1][1]),dp[i-1][2][1])+ arr[i][1];
				// 다음 1번째칸의 최뎃값 = 이전 0,1,2번째 값 최댓값중 큰것 + 현재
				dp[i][2][0] = Math.min(dp[i-1][1][0] , dp[i-1][2][0]) + arr[i][2];
				// 다음 2번째칸의 최솟값 = 이전 1번째칸, 2번째값 최솟값중 작은것 + 현재값 
				dp[i][2][1] = Math.max(dp[i-1][1][1] , dp[i-1][2][1]) + arr[i][2];
				// 다음 2번째칸의 최댓값 = 이전 1번째칸, 2번째값 최댓값중 큰것 + 현재값 
			}
			Min =Math.min(Math.min(dp[N-1][0][0], dp[N-1][1][0]), dp[N-1][2][0]) ;
			Max =Math.max(Math.max(dp[N-1][0][1], dp[N-1][1][1]), dp[N-1][2][1]) ;
		}
}
