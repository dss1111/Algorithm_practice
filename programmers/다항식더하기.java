import java.util.*;

class Solution {
    public String solution(String polynomial) {
        int xCount = 0;
        int numCount = 0;
        polynomial=polynomial.replaceAll(" ",""); // 공백제거
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<polynomial.length();i++){
            char now = polynomial.charAt(i);
            if(now == 'x'){
                if(sb.length()==0){
                    // 처음부터 x
                    xCount++;
                } else {
                    xCount+= Integer.parseInt(sb.toString());
                }
                sb = new StringBuffer();
            } else if(now == '+'){
                if(sb.length()!=0){
                    numCount+=Integer.parseInt(sb.toString());
                }
                sb = new StringBuffer();
            } else{
                sb.append(now);
            }
        }
        if(sb.length()!=0){
            numCount+=Integer.parseInt(sb.toString());
        }
        sb = new StringBuffer();
        if(xCount !=0){
            if(xCount != 1){
                sb.append(xCount).append("x");
            } else {
                sb.append("x"); // 1x인 경우 x로 표기
            }
        }
        if(xCount !=0 && numCount !=0){
            sb.append(" + ");
        }
        if(numCount !=0){
            sb.append(numCount);
        }
        return sb.toString();
    }
}
