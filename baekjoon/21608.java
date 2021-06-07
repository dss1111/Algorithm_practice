
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj21608 {
	static int N;
	static int [][] seats;
	static List <int[]> like = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		seats = new int[N][N];
		for(int n=0;n<N*N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int me = Integer.parseInt(st.nextToken());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			int f3 = Integer.parseInt(st.nextToken());
			int f4 = Integer.parseInt(st.nextToken());
			int [] friends= {me,f1,f2,f3,f4}; //내번호, 좋아하는사람들 1,2,3,4
			like.add(friends);
			getSeat(n);
		}
		System.out.println(getResult());
	}
	static void getSeat(int index) {
		if(index==0) { //첫번째 학생은 자리고정
			seats[1][1]=like.get(index)[0];
			return;
		}
		int [][][] scores = new int[N][N][2];
		int maxLike=0;
		int maxEmpty=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(seats[i][j]!=0) continue;
				scores[i][j]=getScore(index,i,j);
				maxLike = Math.max(maxLike, scores[i][j][0]); 
				maxEmpty = Math.max(maxEmpty, scores[i][j][1]);
			}
		}
		if(maxLike==0 && maxEmpty==0) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(seats[i][j]==0) {
						seats[i][j]=like.get(index)[0];
						return;
					}
				}
			}

		}
		List <int[]> candidate = new ArrayList<>(); //좋아하는 헉생이 많은 자리
		int maxCandidateEmpty = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(scores[i][j][0]==maxLike) {
					candidate.add(new int[] {i,j,scores[i][j][1]});
					maxCandidateEmpty = Math.max(maxCandidateEmpty, scores[i][j][1]);
				}
			}
		}
		if(candidate.size()==0) { //좋아하는 학생이 많은 자리가 없음 빈자리 많은 곳 선택
			loop: for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(scores[i][j][2]==maxEmpty) {
						seats[i][j]=like.get(index)[0];
						break loop;
					}
				}
			}
		}
		else if(candidate.size()>=2) { // 좋아하는 학생이 많은 자리가 둘이상
			for(int [] c : candidate) {
				if(c[2]==maxCandidateEmpty) {
					seats[c[0]][c[1]]=like.get(index)[0];
					break;
				}
			}
		}
		else { // 좋아하는 학생이 앉은 자리가 유일
			seats[candidate.get(0)[0]][candidate.get(0)[1]]=like.get(index)[0];
		}
		
	}
	static int[] getScore(int index,int i,int j) {
		int [][] next = {{1,0},{-1,0},{0,1},{0,-1}};
		int [] score= {0,0}; //좋아하는 학생수, 빈공간수
		for(int k=0;k<4;k++) {
			int nextI = i+next[k][0];
			int nextJ = j+next[k][1];
			
			if(nextI<0 || nextI>=N) continue;
			if(nextJ<0 || nextJ>=N) continue;
			int person = seats[nextI][nextJ];
			if(person==0) { //앉은 사람없음
				score[1]++;
				continue;
			}
			for(int l=1;l<5;l++) { //앉은 사람이 좋아하는 학생인지 체크
				if(person == like.get(index)[l]) {
					score[0]++;
				}
			}
		}
		return score;
	}
	static int getResult() {
		int result = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int now = seats[i][j];
				int index = 0;
				for(int p=0;p<like.size();p++) {
					if(like.get(p)[0]==now) {
						index = p;
						break;
					}
				}
				int score = getScore(index,i,j)[0];
				if(score == 0)
					result+=0;
				if(score == 1)
					result+=1;
				if(score == 2)
					result+=10;
				if(score == 3)
					result+=100;
				if(score == 4)
					result+=1000;
			}
		}
		return result;
	}
}
