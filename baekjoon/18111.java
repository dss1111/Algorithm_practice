import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111 {
	static int N,M,B;
	static int min,max,avg;
	static int result_t=987654321;
	static int result_h=987654321;
	static int [][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				int now = Integer.parseInt(st.nextToken());
				arr[n][m] = now;
				max=Math.max(max,now);
				min=Math.min(min, now);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int h = min;h<=max;h++) {
			int t=0;
			int b=B;
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					int count = arr[n][m] - h;
					if(count==0) continue;
					if(count>0) {
						b = b + count;
						t = t + count*2;
					}
					if(count<0){
						b = b + count;
						t = t - count;
					}
				}
			}
			if(b>= 0 && t<= result_t) {
				result_t = t;
				result_h = h;
			}
		}
		sb.append(result_t).append(" ").append(result_h);
		System.out.println(sb);
	}
}
