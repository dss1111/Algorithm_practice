import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15652 {
	static int N,M;
	static StringBuffer sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuffer();
		select(M,1,"");
		System.out.println(sb.toString());
	}
	public static void select(int count, int big,String s) {
		if(count == 0) {
			s = s.substring(1);
			sb.append(s+"\n");
			return;
		}
		for(int i = big;i<=N;i++) {
			String next = s + " "+ i;
			select(count-1,i,next);
		}
	}
}
 
