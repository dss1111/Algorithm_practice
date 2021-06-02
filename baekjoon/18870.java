import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj18870 {
	static int N;
	static int [] arr;
	static int [] sortedArr;
	static Map<Integer,Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
		}
		sortedArr = arr.clone();
		Arrays.sort(sortedArr);
		int index=0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(sortedArr[i])) {
				map.put(sortedArr[i], index++);
			}
		}
		for(int i=0;i<N;i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
}
