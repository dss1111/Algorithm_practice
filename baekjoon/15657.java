import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15657 {

		static int M,N;
		static int [] numbers;
		static int [] result;
		static StringBuffer sb;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = new int [M];
			numbers = new int [N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(numbers);
			sb = new StringBuffer();
			getNumber(0,0);
			System.out.println(sb);
		}
		public static void getNumber(int min, int count) {
			if(count == M) {
				for(int i=0;i<M;i++) {
					sb.append(result[i]+" ");
				}
				sb.append("\n");
				return;
			}
			for(int i=min; i<N; i++) {
				result[count] = numbers[i];
				getNumber(i, count + 1);
			}
		}
}
