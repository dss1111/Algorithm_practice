import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18429 {
		static int N,K,result;
		static boolean []use;
		static int [] weight;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			weight = new int[N];
			use = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(st.nextToken())-K;
			}
			getResult(0,0);
			System.out.println(result);
		}
		public static void getResult(int chosen,int sum) {
			if(sum < 0)
				return;
			if(chosen==N)
				result++;
			for(int i=0;i<N;i++) {
				if(use[i]) continue;
				use[i] = true;
				getResult(chosen+1,sum+weight[i]);
				use[i] = false;
			}
		}
}
