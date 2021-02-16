import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String str = br.readLine();
		String bomb = br.readLine();
		int endIdx=bomb.length()-1;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			sb.append(str.charAt(i));
			if(str.charAt(i)!=bomb.charAt(endIdx)) {
				continue;
			}
			int count=1;
			for(int j=1;j<=endIdx;j++) {
				if(0<=sb.length()-j-1 && sb.charAt(sb.length()-j-1)==bomb.charAt(endIdx-j)) {
					count++;
				}
			}
			if(count==endIdx+1) {
				sb.replace(sb.length()-endIdx-1, sb.length(), "");
			}
		}
		if(sb.length()==0) {
			System.out.println("FRULA");
		}
		else
			System.out.println(sb);
	}
}
