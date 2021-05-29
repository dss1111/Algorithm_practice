import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj1764 {

	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap <String,Integer>map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		for(int n=0;n<N;n++) {
			map.put(br.readLine(),0);
		}
		for(int m=0;m<M;m++) {
			String key = br.readLine();
			if(map.containsKey(key)) {
				list.add(key);
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for(String e : list) {
			sb.append(e).append("\n");
		}
		System.out.println(sb);
	}
}
