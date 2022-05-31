import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1074 {
    	static int N,R,C,count;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int pow = (int)Math.pow(2, N);
			getResult(0,0,pow);
		}
	    static void getResult(int y, int x,int n) {
	        if (y == R && x == C) {
	            System.out.println(count);
	            return;
	        }
	        if (y <= R && R < (y + n) && x <= C && C < (x + n)) {
	            int half = n / 2;
	            getResult(y, x,half);
	            getResult(y, x + half,half);
	            getResult(y + half, x,half);
	            getResult(y + half, x + half,half);
	        } else {
	            count = count+ n * n;
	        }
	    }
}
