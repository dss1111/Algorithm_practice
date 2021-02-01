import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int [] switches;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		switches = new int[size+1];
		for(int i=1;i<size+1;i++) {
			switches[i]=Integer.parseInt(st.nextToken());
		}
		int people=Integer.parseInt(br.readLine());
		for(int i=0;i<people;i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("1")) {
				man(Integer.parseInt(st.nextToken()));
			}
			else {
				woman(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=1;i<switches.length;i++) {
			System.out.print(switches[i]+" ");
			if(i%20==0)
				System.out.println();
		}
	}
	public static void man(int num) {
		int add=num;
		while(num<switches.length) {
			switches[num]=1-switches[num];
			num+=add;
		}
	}
	public static void woman(int num) {
		switches[num]=1-switches[num];
		for(int i=1;i<switches.length;i++) {
			if((num-i)>=1 && (num+i)<switches.length) {
				if(switches[num-i]==switches[num+i]) {
				switches[num-i]=1-switches[num-i];
				switches[num+i]=switches[num-i];
				}
				else 
					break;
			}
			else
				break;
		}
	}
}
