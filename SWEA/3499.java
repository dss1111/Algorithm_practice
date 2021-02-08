import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static Queue<String>q1;
	static Queue<String>q2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int test = Integer.parseInt(br.readLine());
		int size;
		for(int t=0;t<test;t++) {
			q1=new LinkedList<>();
			q2=new LinkedList<>();
			size =Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			sb.append("#"+(t+1));
			sb.append(" ");
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<size/2;i++) {
				q1.add(st.nextToken());
			}
			if(size%2==1) {
				q1.add(st.nextToken());
			}
			for(int i=0;i<size/2;i++) {
				q2.add(st.nextToken());
			}
			for(int i=0;i<size/2+1;i++) {
				if(!q1.isEmpty()) {
					sb.append(q1.poll());
					sb.append(" ");
				}
				if(!q2.isEmpty()) {
					sb.append(q2.poll());
					sb.append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
