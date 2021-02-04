import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int [][]arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
	    int test = Integer.parseInt(br.readLine());
	    String str;
	    char [] ch;
	    for(int t=0;t<test;t++) {
	        int N = Integer.parseInt(br.readLine());
	        arr=new int[N][N];
		    int sum=0;
	        for(int i=0;i<N;i++) {
	        	str=br.readLine();
	        	ch=str.toCharArray();
	        	for(int j=0;j<N;j++) {
	        		//arr[i][j]=Integer.parseInt(str.substring(j, j+1));
	        		arr[i][j]=ch[j]-'0'; //글자 0부터 9까지는 아스키코드 1씩차이난다.
	        		if((Math.abs(N/2-i)+Math.abs(N/2-j))<=(N/2)) {
	        			sum+=arr[i][j];
	        		}
	        	}
	        }
	        System.out.print("#"+(t+1)+" ");
	        System.out.println(sum);
	    }
	}
}
