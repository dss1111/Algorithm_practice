import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person{
	int num;
	int trueCount;
	int falseCount;
	Person(int num){
		this.num=num;
		trueCount=0;
		falseCount=0;
	}
}
public class Main {
	static ArrayList<Person> list = new ArrayList<>();
	static int[] person ;
	static int[][] opinion; //0 모름 1 true 2 false
	static int[] fact ; //0미응답 1true 2 false 3엇갈림
	final static int size = 9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		opinion = new int[size][size];
		for(int i=0;i<size;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Person p=null;
			boolean checkList=false;
			for(Person s : list) {
				if(s.num==b) {
					p=s;
					if(a==1)
						p.trueCount++;
					else
						p.falseCount++;
					checkList=true;
				}
			}
			if(!checkList) {
				p = new Person(b);
				if(a==1)
					p.trueCount++;
				else
					p.falseCount++;
			}
			list.add(p);
		}
		person = new int[] {0,1,2,3,4,5,6,7,8};
	}
}
