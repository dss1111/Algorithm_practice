import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack <Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length;i++) {
			if(input[i]=='+'||input[i]=='-') {
				while(!stack.isEmpty()&&stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.add(input[i]);
			}
			else if(input[i]=='*'||input[i]=='/') {
				while(!stack.isEmpty()&&(stack.peek()=='*'||stack.peek()=='/')) {
					sb.append(stack.pop());
				}
				stack.add(input[i]);
			}
			else if(input[i]==')') {
				while(!stack.isEmpty()&&stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else if(input[i]=='(') {
				stack.add(input[i]);
			}
			else{
				sb.append(input[i]);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
