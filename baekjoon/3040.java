import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	final static int size = 9;
	static int [] arr=new int[size];
	static int [] select = new int[] {1,1,1,1,1,1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<size;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		do {
			int sum=0;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<size;i++) {
				if(select[i]==1) {
					sum+=arr[i];
				}
			}
			if(sum==100) {
				for(int i=0;i<size;i++) {
					if(select[i]==1) {
						sb.append(arr[i]).append("\n");
					}
				}
				System.out.println(sb);
				break;
			}

		}while(next_permutation());
	}
	static boolean next_permutation() {
		int i = size - 1;
		int j = size - 1;
		while(i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if(i == 0) {
			return false;
		}
		while(arr[i - 1] >= arr[j]) {
			j--;
		};
		
		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;
		
		int k = size - 1;
		while(i < k) {
			tmp = arr[i];
			arr[i] = arr[k];
			arr[k] = tmp;
			i++;
			k--;
		}
		return true;
	}
}
