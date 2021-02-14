import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static Deque<String> dq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		char [] func;
		String[] arr;
		testloop: for(int t=1;t<=test;t++) {
			boolean reverse=false;
			func = br.readLine().toCharArray();
			int n=Integer.parseInt(br.readLine());
			dq = new ArrayDeque<String> ();
			if(n!=0) {
				arr = br.readLine().replace("[", "").replace("]", "").split(",");
				for(String s: arr) {
					dq.addLast(s);
				}
			}
			else {
				br.readLine();
			}
			for(int i=0;i<func.length;i++) {
				if(func[i]=='R') {
					reverse =!reverse;
					continue;
				}
				if(func[i]=='D') {
					if(dq.isEmpty()) {
						System.out.println("error");
						continue testloop;
					}
					if(reverse) {
						dq.removeLast();
					}
					else {
						dq.removeFirst();
					}
				}
			}
			if(reverse) {
				printReverse();
			}
			else {
				print();
			}
		}
	}
	public static void print() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		while(!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(",");
		}
		if(sb.length()!=1)
			sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		System.out.println(sb);
	}
	public static void printReverse() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		while(!dq.isEmpty()) {
			sb.append(dq.pollLast()).append(",");
		}
		if(sb.length()!=1)
			sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		System.out.println(sb);
	}
}
