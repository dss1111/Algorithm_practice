import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M;
	static int count=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		boolean [] check=new boolean[N+1];
		combi(0,1,check);
		System.out.println(count);
	}
	public static void combi(int cnt, int start,boolean[] check ) {
		if(cnt==M-N+1) {
			for(int i=1;i<=N;i++) {
				if(check[i]==false)
					return;
			}
			count++;
			return;
		}
		for(int i=start;i<=N;i++) {
			check[i]=true;
			boolean[] nCheck = new boolean[N+1];
			for(int j=1;j<=N;j++) {
				nCheck[j]=check[j];
			}
			combi(cnt+1,i,nCheck);
		}
	}
}
