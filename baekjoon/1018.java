import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		char [] check1 = {'B','W','B','W','B','W','B','W'};
		char [] check2 = {'W','B','W','B','W','B','W','B'};
		char [][] checkBoard1 = {check1,check2,check1,check2,check1,check2,check1,check2};
		char [][] checkBoard2 = {check2,check1,check2,check1,check2,check1,check2,check1};
		char [][] board = new char[N][M];
		for(int i=0;i<N;i++)
		{
			board[i]=br.readLine().toCharArray();
		}
		int result=64;
		int score;
		int score1;
		int score2;
		for(int i=0;i<N-7;i++)
		{
			for(int j=0;j<M-7;j++)
			{
				score=0;
				score1 = 0;
				score2 = 0;
				for(int p=0;p<8;p++)
				{
					for(int q=0;q<8;q++)
					{
						if(checkBoard1[p][q]!=board[i+p][j+q]) {
							score1++;
						}
						if(checkBoard2[p][q]!=board[i+p][j+q]) {
							score2++;
						}
					}
				}
				score=(score1<score2)?score1:score2;
				result=(score<result)?score:result;
			}
		}
		System.out.println(result);
	}
}
