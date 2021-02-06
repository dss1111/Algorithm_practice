import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	static Stack <Character> stack;
	static Stack <Integer> calculate;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size;
		StringBuilder infix;
		StringBuilder postfix;
		char now;
		for(int t=0;t<10;t++) {
			stack = new Stack<>();
			size = Integer.parseInt(br.readLine());
			infix = new StringBuilder(br.readLine());
			postfix = new StringBuilder();
			for(int i=0;i<size;i++) {
				now = infix.charAt(i);
				if(now=='+') {
					if(!stack.empty()) {
						stack.pop();
						postfix.append('+');
					}
					stack.push('+');
				}
				else if(now=='*') {
					postfix.append(infix.charAt(++i));
					postfix.append('*');
				}
				else 
					postfix.append(now);
			}
			while(!stack.empty()) {
				postfix.append(stack.pop());
			}
			calculate=new Stack<>();
			for(int i=0;i<size;i++) {
				now=postfix.charAt(i);
				if(now=='*'){
					calculate.add(calculate.pop()*calculate.pop());
				}
				else if(now== '+'){
					calculate.add(calculate.pop()+calculate.pop());
				}
				else {
					calculate.add(now-'0');
				}
			}
			System.out.println("#"+(t+1)+" "+calculate.pop());
		}
	}
}
