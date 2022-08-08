import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2304 {
	static int N,result;
	static class Pillar implements Comparable<Pillar>{
		int loc;
		int height;
		Pillar(int l, int h){
			this.loc = l;
			this.height = h;
		}
		@Override
		public int compareTo(Pillar o) {
			return loc - o.loc;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Pillar> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			list.add(new Pillar(l,h));
		}
		Collections.sort(list);
		int prevHeight = 0;
		int prevLoc = 0;
		for(int i=0;i<N;i++) {
			int nowHeight = list.get(i).height;
			int nowLoc = list.get(i).loc;
			if(i==0) {
				prevHeight = nowHeight;
				prevLoc = nowLoc;
			}
			if(prevHeight <= nowHeight) {
				result += (nowLoc-prevLoc) * prevHeight;
				prevHeight = nowHeight;
				prevLoc = nowLoc;
			}
		}
		result+=prevHeight;
		for(int i=N-1;i>=0;i--) {
			int nowHeight = list.get(i).height;
			int nowLoc = list.get(i).loc;
			if(i==N-1) {
				prevHeight = nowHeight;
				prevLoc = nowLoc;
			}
			if(prevHeight < nowHeight) {
				result += (prevLoc-nowLoc) * prevHeight;
				prevHeight = nowHeight;
				prevLoc = nowLoc;
			}
		}
		System.out.println(result);
	}
}
