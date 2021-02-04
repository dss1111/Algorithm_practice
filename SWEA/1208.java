import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static Deque<Integer> dq;
	static Queue<Integer> pq=new PriorityQueue<>();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dump=0;
		int token=0;
		int high,low;
		for(int i=0;i<10;i++) {
			dump=Integer.parseInt(br.readLine());
			dq = new LinkedList<>();
			st =new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				token=Integer.parseInt(st.nextToken());
				pq.add(token);
			}
			while(!pq.isEmpty()) {
				dq.addLast(pq.poll());
			}
			for(int j=0;j<dump;j++) {
				high=dq.pollLast()-1;
				low=dq.pollFirst()+1;
				while(dq.peekLast()>high) {
					pq.add(dq.pollLast());
				}
				dq.addLast(high);
				while(!pq.isEmpty()) {
					dq.addLast(pq.poll());
				}
				while(dq.peekFirst()<low) {
					pq.add(dq.pollFirst());
				}
				dq.addFirst(low);
				while(!pq.isEmpty()) {
					dq.addFirst(pq.poll());
				}
			}
			System.out.println("#"+(i+1)+" "+(dq.peekLast()-dq.peekFirst()));
		}
	}
}
