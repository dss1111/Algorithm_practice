import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int [][] arr;
	static int num;
	static int size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		for(int i=0;i<testCase;i++) {
			size=Integer.parseInt(br.readLine());
			arr = new int [size][size];
			num=0;
			arr[0][0]=++num;
			right(0,0);
			System.out.println("#"+(i+1));
			for(int j=0;j<size;j++) {
				for(int k=0;k<size;k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}
		}
	}
	public static void right(int i,int j) {
		if(num==size*size)
			return;
		int k;
		for(k=1;j+k<size && arr[i][j+k]==0;k++) {
			arr[i][j+k]=++num;
		}
		down(i,j+k-1);
		return;
	}
	public static void down(int i,int j) {
		if(num==size*size)
			return;
		int k;
		for(k=1;i+k<size && arr[i+k][j]==0;k++) {
			arr[i+k][j]=++num;
		}
		left(i+k-1,j);
		return;
	}
	public static void left(int i,int j) {
		if(num==size*size)
			return;
		int k;
		for(k=1;j-k>=0 && arr[i][j-k]==0;k++) {
			arr[i][j-k]=++num;
		}
		up(i,j-k+1);
		return;
	}
	public static void up(int i,int j) {
		if(num==size*size)
			return;
		int k;
		for(k=1;i-k>=0 && arr[i-k][j]==0;k++) {
			arr[i-k][j]=++num;
		}
		right(i-k+1,j);
		return;
	}
}
