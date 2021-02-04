import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static String[][] arr;
	static int x;
	static int y;
	static int dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		int h,w;
		String str;
		for(int t=0;t<test;t++) {
			System.out.print("#"+(t+1)+" ");
			st=new StringTokenizer(br.readLine());
			h=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			arr=new String[h][w];
			for(int i=0;i<h;i++) {
				str=br.readLine();
				for(int j=0;j<w;j++) {
					arr[i][j]=str.substring(j,j+1);
					if(arr[i][j].equals("^")) {
						x=j;
						y=i;
						dir=0;
						arr[i][j]=".";
					}
					else if(arr[i][j].equals("v")) {
						x=j;
						y=i;
						dir=1;
						arr[i][j]=".";
					}
					else if(arr[i][j].equals("<")) {
						x=j;
						y=i;
						dir=2;
						arr[i][j]=".";
					}
					else if(arr[i][j].equals(">")) {
						x=j;
						y=i;
						dir=3;
						arr[i][j]=".";
					}
				}
			}
			int inputSize=Integer.parseInt(br.readLine());
			char[] input=br.readLine().toCharArray();
			for(int i=0;i<inputSize;i++) {
				if(input[i]=='U') {
					dir=0;
					if(y!=0 && arr[y-1][x].equals(".")) {
						y=y-1;
					}
				}
				else if(input[i]=='D') {
					dir=1;
					if(y!=h-1 && arr[y+1][x].equals(".")) {
						y=y+1;
					}
				}
				else if(input[i]=='L') {
					dir=2;
					if(x!=0 && arr[y][x-1].equals(".")) {
						x=x-1;
					}
				}
				else if(input[i]=='R') {
					dir=3;
					if(x!=w-1 && arr[y][x+1].equals(".")) {
						x=x+1;
					}
				}
				else if(input[i]=='S') {
					int b_x=x;
					int b_y=y;
					if(dir==0) {
						while(true) {
							if(b_y==0)
								break;
							if(arr[b_y-1][b_x].equals("#"))
								break;
							if(arr[b_y-1][b_x].equals("*")) {
								arr[b_y-1][b_x]=(".");
								break;
							}
							b_y--;
						}
					}
					else if(dir==1) {
						while(true) {
							if(b_y==h-1)
								break;
							if(arr[b_y+1][b_x].equals("#"))
								break;
							if(arr[b_y+1][b_x].equals("*")) {
								arr[b_y+1][b_x]=".";
								break;
							}
							b_y++;
						}
					}
					else if(dir==2) {
						while(true) {
							if(b_x==0)
								break;
							if(arr[b_y][b_x-1].equals("#"))
								break;
							if(arr[b_y][b_x-1].equals("*")) {
								arr[b_y][b_x-1]=".";
								break;
							}
							b_x--;
						}
					}
					else {
						while(true) {
							if(b_x==w-1)
								break;
							if(arr[b_y][b_x+1].equals("#"))
								break;
							if(arr[b_y][b_x+1].equals("*")) {
								arr[b_y][b_x+1]=".";
								break;
							}
							b_x++;
						}
					}
				}
			}
			if(dir==0)
				arr[y][x]="^";
			if(dir==1)
				arr[y][x]="v";
			if(dir==2)
				arr[y][x]="<";
			if(dir==3)
				arr[y][x]=">";
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
