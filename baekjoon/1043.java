import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1043 {
	static int N,M;
	static boolean[] isKnow;
	static int[] parent;
	static List<Integer>[] people;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isKnow = new boolean[N+1];
		people = new ArrayList[M];
		for(int i=0; i<M; i++) {
			people[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		while(st.hasMoreTokens()) {
			isKnow[Integer.parseInt(st.nextToken())] = true;
		}
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		int person1 = 0;
		int person2 = 0;
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			if(count  > 0) {
				person1 = Integer.parseInt(st.nextToken());
				people[m].add(person1);
			}
			for(int j=1; j<count; j++) {
				person2 = Integer.parseInt(st.nextToken());
				people[m].add(person2);
				union(person1, person2); // 두명씩 union하면 모두가 같은 parent를 갖게 됨.
				person1 = person2;
			}
		}
		getResult();
	}
	public static void getResult() {
		int result = 0;
		for(int i=0;i<=N;i++) {
			if(isKnow[i]) {
				isKnow[find(i)] = true;
			}
		}
		int parent;
		for(int i=0;i<M;i++) {
			if(people[i].size() > 0) {
				parent = find(people[i].get(0));
				if(!isKnow[parent]) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
    public static int find(int index) {
        if(parent[index]==index){
            return index;
        }
        parent[index] = find(parent[index]);
        return parent[index];
    }

    public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!= b) {
			if(a>b) {
				parent[a] = b;
			} else {
				parent[b] = a;
			}
		}
    }
}
