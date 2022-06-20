import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
		static ArrayDeque <Character> dq1 = new ArrayDeque<>(); // 커서 앞
		static ArrayDeque <Character> dq2 = new ArrayDeque<>(); // 커서 뒤
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char [] word = br.readLine().toCharArray();
			for(int i=0;i<word.length;i++) {
				dq1.addLast(word[i]);
			}
			int M = Integer.parseInt(br.readLine());
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String token = st.nextToken();
				if(token.equals("L")) {
					if(!dq1.isEmpty()) {
						dq2.addFirst(dq1.pollLast());
					}
				}
				if(token.equals("D")) {
					if(!dq2.isEmpty()) {
						dq1.addLast(dq2.pollFirst());
					}
				}
				if(token.equals("B")) {
					if(!dq1.isEmpty()) {
						dq1.pollLast();
					}
				}
				if(token.equals("P")) {
					token = st.nextToken();
					dq1.addLast(token.charAt(0));
				} 
			}
			StringBuffer sb = new StringBuffer();
			for(Character c : dq1) {
				sb.append(c);
			}
			for(Character c : dq2) {
				sb.append(c);
			}
			System.out.println(sb);
		}
}
