import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bj2579 {
		static int N;
		static int[] stair;
		static int[] point;
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());
	        stair = new int[301];
	        point = new int[301];
	        for (int i = 1; i <= N; i++)
	            stair[i] = Integer.parseInt(br.readLine());
	        point[1]= stair[1];
	        point[2]= stair[1] + stair[2];
	        point[3]= Math.max(stair[1]+stair[3],stair[2]+stair[3]);
	        
	        for (int n = 4;n <= N; n++) {
	            point[n] = Math.max(point[n-3] + stair[n]+ stair[n-1], point[n-2] + stair[n]);
	        }
	        System.out.println(point[N]);
	    }
}
