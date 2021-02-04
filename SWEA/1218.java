import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	static Stack<Character> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size;
		char [] input;
		char top;
		int i,result;
		for(int t=0;t<10;t++) {
			size=Integer.parseInt(br.readLine());
			input=br.readLine().toCharArray();
			stack= new Stack<>();
			result=1;
			loop: for(i=0;i<size;i++) {
				if(input[i]=='(' || input[i]=='['||input[i]=='{'||input[i]=='<') {
					stack.add(input[i]);
				}
				else {
					if(stack.empty()) {
						result=0;
						break loop;
					}
					top=stack.pop();
					switch(top) {
					case '(':
						if(input[i]!=')') {
							result=0;
							break loop;
						}
							break;
					case '[':
						if(input[i]!=']') {
							result=0;
							break loop;
						}
						break;
					case '{':
						if(input[i]!='}') {
							result=0;
							break loop;
						}
						break;
					case '<':
						if(input[i]!='>') {
							result=0;
							break loop;
						}
					}
				}
			}
			System.out.print("#"+(t+1)+" ");
			System.out.println(result);
		}
	}
}
