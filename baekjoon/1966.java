import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static Queue <int[]> q ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<test;t++) {
			q = new LinkedList <>();
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int [] temp = new int[2];
				temp[0] = i;
				temp[1] = Integer.parseInt(st.nextToken());
				q.add(temp);
			}
			boolean pass;
			int result = 0;
			while(!q.isEmpty()) {
				int [] now = q.poll();
				pass = false;
				for(int [] next : q) {
					if(next[1]>now[1]) {
						pass = true;
					}
				}
				if(pass) {
					q.add(now);
					continue;
				}
				else {
					result++; 
					if (now[0]== M) { 
						System.out.println(result);
						break;
					}
				}
			}
		}
	}
}
