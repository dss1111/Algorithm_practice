import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char [][] map;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		result=0;
		for(int i=0;i<R;i++) {
			map[i]=br.readLine().toCharArray();
		}
		boolean [] alpha=new boolean[26];
		go(0,0,1,alpha);
		System.out.println(result);
	}
	static void go(int r,int c,int level,boolean [] alpha) {
		if(alpha[map[r][c]-65]) return;
		result=Math.max(result, level);
		alpha[map[r][c]-65]=true;
		if(r!=0) { //위
			go(r-1,c,level+1,alpha.clone());
		}
		if(c!=0) { //왼
			go(r,c-1,level+1,alpha.clone());
		}
		if(c<C-1) { //오른
			go(r,c+1,level+1,alpha.clone());
		}
		if(r<R-1) { //아래
			go(r+1,c,level+1,alpha.clone());
		}
		return;
	}
}
