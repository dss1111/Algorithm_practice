import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class bj2407 {
	static int N,M;
	static BigInteger [][] dp = new BigInteger[101][101];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		System.out.println(combi(N,M));
	}
	static BigInteger combi(int n,int r) {
		if(dp[n][r]!=null) {
			return dp[n][r];
		}
		if(n==r||r==0) return BigInteger.ONE;
		dp[n][r] = combi(n-1,r-1).add(combi(n-1,r)) ;
		return dp[n][r];
	}
}
