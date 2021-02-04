import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int [][]arr;
	static StringTokenizer st;
	static int start;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String token;
		for(int t=0;t<10;t++) {
			br.readLine();
			arr=new int[100][100];
			start=0;
			for(int i=0;i<100;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					token=st.nextToken();
					if(token.equals("1")) {
						arr[i][j]=1;
					}
					else {
						arr[i][j]=2;
					}
				}
				
			}
			System.out.print("#"+(t+1)+" ");
			find: for(int j=0;j<100;j++) {
				if(arr[0][j]==1) {
					int flag=0; //0아래 1왼 2오른
					start=j;
					int x=j;
					int y=0;
					while(true) {
						if(y==99) {//마지막
							if(arr[y][x]==2) {
								System.out.println(start);
								break find;
							}
							break;
						}
						if(x!=0 && flag!=2 &&arr[y][x-1]==1) { // 왼쪽
							flag=1;
							x=x-1;
						}
						else if(x!=99 && flag!=1 &&arr[y][x+1]==1) { //오른쪽
							flag=2;
							x=x+1;
						}
						else { //아래
							flag=0;
							y=y+1;
						}
					}
				}
			}
		}
	}
}
