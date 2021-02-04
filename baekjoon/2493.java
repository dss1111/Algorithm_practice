import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack <Integer> indexStack= new Stack<>();
	static int [] tower;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height;
		tower=new int[t];
		int result;
		for(int i=0;i<t;i++) {
			height=Integer.parseInt(st.nextToken());
			tower[i]=height;
			while(!indexStack.empty() && tower[indexStack.peek()]<height) {
				indexStack.pop();
			}
			if(indexStack.empty()) {
				indexStack.add(i);
				result=0;
			}
			else {
				result=indexStack.peek()+1;
				indexStack.add(i);
			}
			System.out.print(result+" ");
		}
	}
}
