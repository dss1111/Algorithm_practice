import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        int count,i,j;
        char[] array;
        for(i=0;i<testCase;i++) {
            array=br.readLine().toCharArray();
            count=0;
            if(array[0]=='1'){
                count++;
            }
            for(j=1;j<array.length;j++) {
                if(array[j]!=array[j-1]) {
                    count++;
                }
            }
            System.out.println("#"+(i+1)+" "+count);
        }
    }
}
