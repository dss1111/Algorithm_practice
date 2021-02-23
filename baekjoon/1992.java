import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] board;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];
		for(int i=0;i<N;i++) {
			char [] charArray=br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				if(charArray[j]=='1')
					board[i][j]=true;
			}
		}
		getResult(0,0,N);
		System.out.println(sb);
	}
	static boolean isSame(int c,int r,int size) {
		boolean first = board[c][r];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[c+i][r+j]!=first)
					return false;
			}
		}
		return true;
	}
	static void getResult(int c,int r,int size) {
		if(isSame(c,r,size)) {
			if(board[c][r])
				sb.append(1);
			else
				sb.append(0);
			return;
		}
		sb.append("(");
		int half = size/2;
		getResult(c,r,half);
		getResult(c,r+half,half);
		getResult(c+half,r,half);
		getResult(c+half,r+half,half);
		sb.append(")");
	}
}
