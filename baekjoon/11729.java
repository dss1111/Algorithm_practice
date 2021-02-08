import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int result=0;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		hanoi(num,1,2,3);
		System.out.println(result);
		System.out.println(sb);
	}
	public static void hanoi(int num, int from, int mid, int to) {
		if(num==0) return;
		result++;
		hanoi(num-1,from,to,mid);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(num-1,mid,from,to);
	}
}
