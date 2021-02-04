import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static Deque <Integer> dq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int temp;
		int value;
		int now;
		for(int t=0;t<10;t++) {
			dq = new ArrayDeque<Integer>();
			temp=Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}
			value=0;	
			while(dq.peekLast()>0) {
				now=dq.pollFirst();
				now=now-(value%5+1);
				dq.addLast(now);
				value++;
			}
			System.out.print("#"+(t+1)+" ");
			for(int i=0;i<7;i++) {
				System.out.print(dq.pollFirst()+" ");
			}
			System.out.println("0");
		}
	}
}
