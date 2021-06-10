import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9465 {
	static int T,N;
	static int [][] sticker;
	static int [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			sticker = new int[2][N];
			dp = new int[2][N];
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int n=0;n<N;n++) {
					sticker[i][n]= Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			if(N>=2) {
				dp[0][1] = dp[1][0]+sticker[0][1];
				dp[1][1] = dp[0][0]+sticker[1][1];
			}
			for(int n=2;n<N;n++) {
				//두칸 건너뛰는 것과 한칸건너뛰는 것중에 큰값
				dp[0][n] = Math.max(dp[1][n-1]+sticker[0][n], dp[1][n-2]+sticker[0][n]);
				dp[1][n] = Math.max(dp[0][n-1]+sticker[1][n], dp[0][n-2]+sticker[1][n]);
			}
			sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
		}
		System.out.println(sb);
	}
}
