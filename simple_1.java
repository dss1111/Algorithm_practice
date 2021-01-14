class Solution {
    public String solution(int n) {
        String answer = "";
        int num = n;
        String next="";
        while(num > 0){
            int r= num % 3;
            num /= 3;
            if(r == 0){
                num--;
            }
            switch(r)
            {
                case 0:
                    next="4";
                    break;
                case 1:
                    next="1";
                    break;
                case 2:
                    next="2";
                    break;
            }
            answer = next + answer;
        }
        return answer;
    }
}
