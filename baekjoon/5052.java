import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj19638 {
		static int T,N;
		static String[] numbers;
		static StringBuffer sb;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			T = Integer.parseInt(br.readLine());
			sb = new StringBuffer();
			for(int t=0;t<T;t++) {
				N = Integer.parseInt(br.readLine());
				numbers = new String[N];
				for(int n=0;n<N;n++) {
					numbers[n] = br.readLine();
				}
				getResult();
			}
			System.out.println(sb);
		}
		public static void getResult() {
			Arrays.sort(numbers);
			for(int i=1;i<N;i++) {
				if(numbers[i].startsWith(numbers[i-1])) {
					sb.append("NO\n");
					return;
				}
			}
			sb.append("YES\n");
		}

}
