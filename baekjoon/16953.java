import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16953 {
	static int A,B;
	static int result = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		while(B!=A) {
			if(B < A) {
				result = -1;
				break;
			}
			String str = String.valueOf(B);
			if(B % 2 != 0 && str.charAt(str.length()-1) != '1') {
				result = -1;
				break;
			}
			if(B % 2 == 0) {
				B = B/2;
			} else {
				str = str.substring(0,str.length()-1);
				B = Integer.parseInt(str);
			}
			result++;
		}
		System.out.println(result);
	}
}
 
