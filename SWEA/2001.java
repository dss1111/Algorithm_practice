import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static int[][] arr;
	static int N,M;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=0;t<test;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			arr=new int[N][N];
			max=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			} 
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					getSum(i,j);
				}
			}
			
			System.out.print("#"+(t+1)+" ");
			System.out.println(max);
		}
	}
	public static void getSum(int y,int x) {
		int sum=0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				sum+=arr[y+i][x+j];
			}
		}
		max=Math.max(max, sum);
	}
}
