import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1806 {
	static int N,S,result;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left=0;
		int right=0;
		int sum=arr[0];
		result = 987654321;
		while(left<=right && right<N) {
			if(sum <S) {
				sum +=arr[++right];
			}
			else if(sum == S) {
				result = Math.min(result, (right-left+1));
				sum += arr[++right];
			}
			else if(sum > S) {
				result = Math.min(result, (right-left+1));
				sum -= arr[left++];
			}
		}
		if(result!=987654321) {
			System.out.println(result);
		}
		else {
			System.out.println(0);
		}
	}
}
