
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2467 {
		static int N; 
		static int [] arr;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int mix = Math.abs(arr[0]+arr[N-1]);
			int result1 = arr[0];
			int result2 = arr[N-1];
			int left = 0;
			int right = N-1;
			while(left<right) {
				int nowMix = arr[left] + arr[right];
				if(Math.abs(nowMix) < mix) {
					result1 = arr[left];
					result2 = arr[right];
					mix = Math.abs(nowMix);
				}
				if(nowMix < 0) {
					left++;
				} else {
					right--;
				}
			}
			System.out.println(result1+" "+result2);
		}
}
