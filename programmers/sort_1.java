import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String solution(int[] numbers) {
    	String[] str=new String[numbers.length];
		String answer = "";
		for(int i=0;i<numbers.length;i++)
		{
		    str[i]=String.valueOf(numbers[i]);
		}
		Arrays.sort(str,new Comparator<String>() {
		    public int compare(String i1, String i2)
		    {
		    	return ((i2+i1).compareTo(i1+i2));
		    }
		});
		//이부분 처리하느라 고생.. 0,0,0 예외부분 처리
        if(str[0].equals("0"))
		{
		    return "0";
		}
		for(int i=0;i<str.length;i++)
		{
			answer+=str[i];
		}
		return answer;
    }
}