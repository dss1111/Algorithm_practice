import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1149 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int pre1 = 0;
		int pre2 = 0;
		int pre3 = 0;
		ArrayList <int[]>scores = new ArrayList<>();
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int now1 = Integer.parseInt(st.nextToken());
			int now2 = Integer.parseInt(st.nextToken());
			int now3 = Integer.parseInt(st.nextToken());
			int min1 = Math.min(now1+pre2,now1+pre3);
			int min2 = Math.min(now2+pre1, now2+pre3);
			int min3 = Math.min(now3+pre1, now3+pre2);
			scores.add(new int[] {min1,min2,min3});
			pre1=min1;
			pre2=min2;
			pre3=min3;
		}
		System.out.println(Math.min(Math.min(pre1, pre2), pre3));
	}
}
