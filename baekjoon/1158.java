import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,K;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer>q = new LinkedList<Integer>(); 
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(",").append(" ");
		}
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb);
	}
}
