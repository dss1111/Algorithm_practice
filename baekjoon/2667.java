import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj2667 {
	static int N;
	static char [][] map;
	static int [][] visit;
	static int num;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new int[N][N];
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
		}
		List <Integer> list = new ArrayList<>(); 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='1' && visit[i][j]==0) {
					count = 0;
					dfs(i,j,++num);
					list.add(count);
				}
			}
		}
		System.out.println(num);
		Collections.sort(list);
		for(int i=0;i<num;i++) {
			System.out.println(list.get(i));
		}

	}
	static void dfs(int i, int j,int n) {
		visit[i][j]=n;
		count++;
		int [][] next= {{-1,0},{0,-1},{0,1},{1,0}}; 
		for(int k=0;k<4;k++) {
			int nextI = i + next[k][0];
			int nextJ = j + next[k][1];
			if(nextI<0 || nextI==N) continue;
			if(nextJ<0 || nextJ==N) continue;
			if(map[nextI][nextJ]=='1' && visit[nextI][nextJ]==0) {
				dfs(nextI,nextJ,n);
			}
		}
	}
}
