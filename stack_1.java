import java.util.Stack;
class Solution {
    Stack<Character> stack1 = new Stack<>(); //정방향
    Stack<Character> stack2 = new Stack<>(); //역방향
    public String solution(String p) {
        String answer = "";
        char now;
        for(int i=0;i<p.length();i++)
        {
            now=p.charAt(i);
            if(now=='(')
            {
                if(!stack2.empty()){
                    answer+=')';
                    stack2.pop();
                }
                else{
                    answer+='(';
                    stack1.push('(');
                }
            }
            if(now==')')
            {
                if(!stack1.empty()){
                    answer+=')';
                    stack1.pop();
                }
                else{
                    answer+='(';
                    stack2.push(')');
                }
            }
        }
        return answer;
    }
}
