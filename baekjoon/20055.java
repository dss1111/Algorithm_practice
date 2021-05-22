import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20055 {
	static int N,K;
	static int up,down;
	static Belt [] belt;
	static class Belt{
		boolean robot; //로봇이 있는지 여부
		int dura; //내구도
		Belt(int d){
			dura = d;
		}
		@Override
		public String toString() {
			return "robot=" + robot + ", dura=" + dura;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new Belt[2*N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) { //내구도 설정
			belt[i] = new Belt(Integer.parseInt(st.nextToken()));
		}
		int result=0;
		while(!endCheck()) {
			rotate();
			//System.out.println("회전");
			//print();
			move();
			//System.out.println("이동");
			//print();
			up();
			//System.out.println("올리기");
			//print();
			result++;
		}
		System.out.println(result);
	}
	static void rotate() {
		Belt[] next = new Belt[2*N];
		for(int i=0;i<2*N;i++) {
			next[(i+1)%(2*N)]= belt[i];
		}
		for(int i=0;i<2*N;i++) {
			belt[i]=next[i];
		}
		if(belt[N-1].robot) //이동해서 끝에 도달
			belt[N-1].robot=false; //로봇 내리기
	}
	static void move() {
		for(int i=N-1;i>0;i--) {
			if(belt[i].dura>=1 && belt[i-1].robot && !belt[i].robot) { //앞에 로봇이 있고 뒤에 로봇이 없고 내구도가 있으면
				belt[i].robot=belt[i-1].robot;
				belt[i-1].robot = false;
				belt[i].dura--;
			}
			if(belt[N-1].robot) //이동해서 끝에 도달
				belt[N-1].robot=false; //로봇내리기
		}
	}
	static void up() { //물건올리기
		if(belt[0].dura>=1) { //맨앞이 내구도가 있으면 올리기
			belt[0].robot=true;
			belt[0].dura--;
		}
	}
	static boolean endCheck(){
		int count=0;
		for(int i=0;i<2*N;i++) {
			if(belt[i].dura==0) {
				count++;
			}
		}
		if(count>=K) {
			return true;
		}
		return false;
	}
	static void print() {
		for(int i=0;i<N;i++) {
			if(belt[i].robot)
				System.out.print("X ");
			else
				System.out.print("  ");
		}
		System.out.println();
		for(int i=0;i<N;i++) {
			System.out.print(belt[i].dura+" ");
		}
		System.out.println();
		for(int i=2*N-1;i>=N;i--) {
			System.out.print(belt[i].dura+" ");
		}
		System.out.println();
		System.out.println();
	}
}
