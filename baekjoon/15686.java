import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Location{
		int x,y;
		Location(int y, int x){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Location [x=" + x + ", y=" + y + "]";
		}
	}
	static int N,M;
	static String [][] board;
	static Location [] bbq = new Location[13];
	static int [] check;
	static Location [] home;
	static int result,bbqCount,homeCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		home = new Location[2*N];
		M = Integer.parseInt(st.nextToken());
		board = new String[N][N];
		homeCount=0;
		bbqCount=0;
		result=987654321;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				String now = st.nextToken();
				if(now.equals("1")) {
					home[homeCount++]=new Location(i,j);
				}
				if(now.equals("2")) {
					bbq[bbqCount++]=new Location(i,j);
				}
			}
		}			
		check=new int[bbqCount];
		for(int i=bbqCount-1;i>=0;i--) {
			if(M<=0) break;
			check[i]=1;
			M--;
		}
		do {
			int [] minTable = new int[homeCount];
			Arrays.fill(minTable, 2000);
			for(int i=0;i<bbqCount;i++) {
				if(check[i] == 1) {
					for(int j=0;j<homeCount;j++) {
						minTable[j]=Math.min(minTable[j],distance(bbq[i],home[j]));
					}
				}
			}
			int sum=0;
			for(int i=0;i<homeCount;i++) {
				sum+=minTable[i];
			}
			result = Math.min(sum, result);
		}while(nextP());
		System.out.println(result);
	}
	static public int distance(Location a, Location b) {
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
	static public boolean nextP() {
		int i = bbqCount-1;
		while(i>0 && check[i-1]>=check[i]) --i;
		
		if(i==0) return false;
		int j = bbqCount-1;
		while(check[i-1]>=check[j])--j;
		swap(i-1,j);
		int k = bbqCount-1;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	static void swap(int i,int j) {
		int temp=check[i];
		check[i]=check[j];
		check[j]=temp;
	}
}
