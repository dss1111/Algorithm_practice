import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1062 {
	static int N,K,result,bit;
	static List <char[]> words = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(K<5) {
			System.out.println(0);
			return;
		}
		if(K==26) {
			System.out.println(N);
			return;
		}
		//(1<<25)>>(alpha - 'a') 왼쪽부터 비트채우기
		//1<<(alpha - 'a') 오른쪽부터 채우기
		bit |= 1<<('a'-'a');
		bit |= 1<<('c'-'a');
		bit |= 1<<('i'-'a');
		bit |= 1<<('n'-'a');
		bit |= 1<<('t'-'a');
		
		for(int n=0;n<N;n++) {
			char[] word = br.readLine().toCharArray();
			words.add(word);
		}
		dfs(0,0,bit);
		System.out.println(result);
	}
	static void dfs(int index, int start,int bit) {
		if(index == K-5) { //종결조건 acint빼고 나머지
			int count = 0;
			for(char[] word : words) { //단어들
				boolean chk = true;
				for(char letter: word) { //글자들
					if((bit&1<<(letter-'a'))==0) { //1&1 = 1 나머지들
						chk = false;
						break;
					}
				}
				if(chk) count++;
			}
			result = Math.max(result, count);
			return;
		}
		// 나머지 브루트포스
		for(int i = start;i<26;i++) {
			if((bit&1<<i)!=0) continue;
			dfs(index+1,i+1,bit | 1<<i);
		}
	}
}
