import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,H,T;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(br.readLine());
			pq.add(a);
		}
		int i;
		for(i=0;i<T;i++) {
			int a = pq.poll();
			if(a < H) {
				pq.add(a);
				break;
			} else {
				if(a != 1) {
					pq.add(a/2);
				} else {
					pq.add(1);
					break;
				}
			}
		}
		if(pq.peek() < H) {
			System.out.println("YES");
			System.out.println(i);
		}
		else {
			System.out.println("NO");
			System.out.println(pq.peek());
		}
	}
}
