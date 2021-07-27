import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1300 {

	/*
	 * 6 이면
	 * 1  2  3  4   4개
	 * 2  4  6  8   2개
	 * 3  6  9  12  1개
	 * 4  8  12 16  1개
	 * 
	 */
	static long N,K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		K = Long.parseLong(br.readLine());

		long start = 1;
		long end = N*N;
		long result = 1;
		while(start <= end ) {
			long mid = (start + end) /2;
			long index = 0;
			for(int i=1;i<=N;i++) {
				index += Math.min(mid/i, N); //줄마다 작거나 같은만큼 인덱스 증가
			}
			if(index >= K) {
				result = mid;
				end = mid-1;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(result);
	}
}
