import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Spot{
		int y;
		int x;
		int side;
		Spot(int side,int distance){
			this.side = side;
			if(side==1) {
				y = 0;
				x = distance;
			}
			if(side==2) {
				y = J;
				x = distance;
			}
			if(side==3) {
				y = distance;
				x = 0;
			}
			if(side==4) {
				y = distance;
				x = I;
			}
		}
	}
	static int I,J,T;
	static List <Spot> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		I = Integer.parseInt(st.nextToken());
		J = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Spot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		System.out.println(getResult());
	}
	static int getResult() {
		Spot dk = list.get(T);
		int result=0;
		int otherside[]= {0,2,1,4,3};
		for(int t=0;t<T;t++) {
			Spot store = list.get(t);
			if(otherside[dk.side]==store.side) {
				if(dk.side==1 || dk.side==2)
					result+=Math.min(dk.x+store.x+J, I-dk.x+I-store.x+J);
				else
					result+=Math.min(dk.y+store.y+I, J-dk.y+J-store.y+I);
			}else if(dk.side == store.side){
				result+=Math.abs(dk.x-store.x)+Math.abs(dk.y - store.y);
			}else{
				if(dk.side==1) {
					if(store.side==3)
						result+=dk.x+store.y;
					if(store.side==4)
						result+=I-dk.x+store.y;
				}
				if(dk.side==2) {
					if(store.side==3)
						result+=dk.x+J-store.y;
					if(store.side==4)
						result+=I-dk.x+J-store.y;
				}
				if(dk.side==3) {
					if(store.side==1)
						result+=dk.y+store.x;
					if(store.side==2)
						result+=J-dk.y+store.x;
				}
				if(dk.side==4) {
					if(store.side==1)
						result+=dk.y+I-store.x;
					if(store.side==2)
						result+=J-dk.y+I-store.x;
				}
			}
		}
		return result;
	}
}
