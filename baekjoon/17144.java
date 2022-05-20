import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17144 {
	static int R,C,T;
	static int [][] board;
	static int cleaner;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				board[r][c]=Integer.parseInt(st.nextToken());
				if(board[r][c] == -1) {
					cleaner = r;
				}
			}
		}
		for(int t=0;t<T;t++) {
			spread();
			clean();
		}
		int sum = 0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				sum += board[r][c];
			}
		}
		System.out.println(sum+2);
	}
	public static void spread() {
		int [][] next = new int[R][C];
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				int [][] nextLoc = {{1,0},{-1,0},{0,1},{0,-1}};
				int spreadCount = 0;
				for(int k=0;k<4;k++) {
					int nextR = r + nextLoc[k][0];
					int nextC = c + nextLoc[k][1];
					if(nextR >= R || nextR < 0 || nextC >= C || nextC < 0) continue;
					if(board[nextR][nextC]==-1) continue;
					next[nextR][nextC]+= board[r][c]/5;
					spreadCount++;
				}
				if(spreadCount != 0) {
					board[r][c] -= spreadCount*(board[r][c]/5);
				}
				next[r][c] += board[r][c];
			}
		}
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				board[r][c]=next[r][c];
			}
		}
	}
	public static void clean() {
        int top = cleaner-1;
        int bottom = cleaner;

        for (int i = top - 1; i > 0; i--) {
        	board[i][0] = board[i-1][0];
        }
        for (int i = 0; i < C - 1; i++) {
        	board[0][i] = board[0][i+1];
        }
        for (int i = 0; i < top; i++) {
        	board[i][C - 1] = board[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
        	board[top][i] = board[top][i-1];
        }
        board[top][1] = 0;

		for(int i = bottom + 1 ; i<R-1; i++) {
			board[i][0] = board[i+1][0];
		}
		for(int i = 0;i<C-1;i++) {
			board[R-1][i] = board[R-1][i+1];
		}
        for (int i = R - 1; i > bottom; i--) {
        	board[i][C - 1] = board[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
        	board[bottom][i] = board[bottom][i - 1];
        }
        board[bottom][1] = 0;
	}
}
