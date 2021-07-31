import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15685 {
	static int N;
	static int x,y,d,g;
	static int [][] dir = {{1,0},{0,-1},{-1,0},{0,1}}; //오른,위,왼,아래
	static List<Integer> dirList;
	static boolean [][] board = new boolean[101][101]; //좌표평면
	static int result; //결과
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			dirList = new ArrayList<>();
			makeDragon(-1);
		}
		/*격자판에서 꼭짓점이 포함된 정사각형 카운트*/
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(board[i][j]&&board[i][j+1]&&board[i+1][j]&&board[i+1][j+1]) //정사각형 꼭짓점이 모두 true
					result++;
			}
		}
		System.out.println(result);
	}
	static void makeDragon(int generation) {
		if(generation == g) //종결조건 
			return;
		if(dirList.isEmpty()) { //0단계
			board[x][y]=true;
			dirList.add(d);
			x = x + dir[d][0];
			y = y + dir[d][1];
			if(x >=0 && x<=100 && y>=0 && y<=100) {
				board[x][y]=true;
			}
		} else {
			int prevSize = dirList.size(); //이전단계의  진행횟수
			/*
			 * 이전 끝점부터 방향을 역순으로 틀면 다음단계의 드래곤 커브를 구할 수 있음
			 */
			for(int i=prevSize-1;i>=0;i--) { 
				int prevDir = dirList.get(i);
				int nowDir = (prevDir+1)%4; //90도 회전
				dirList.add(nowDir);
				x = x + dir[nowDir][0];
				y = y + dir[nowDir][1];
				if(x >=0 && x<=100 && y>=0 && y<=100) { //유효한 범위
					board[x][y]=true;
				}
			}
		}
		makeDragon(generation + 1);
	}
}
