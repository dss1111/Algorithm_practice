import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,K,result;
	static List <Word> words = new ArrayList<>();
	static class Word implements Comparable<Word>{
		char [] word;
		int point;
		int bit;
		Word(String s){
			word = s.toCharArray();
		}
		@Override
		public int compareTo(Word o) {
			return o.point-this.point;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int n=0;n<N;n++) {
			Word w = new Word(br.readLine());
			words.add(w);
			makeBit(w);
		}
		Collections.sort(words);
		for(Word w : words) {
			if(w.point<=K) {
				result++;
			}
		}
		System.out.println(result);
	}
	static void makeBit(Word w) {
		int bit=0;
		char [] word = w.word;
		for(int i=0;i<w.word.length;i++) {
			int now = (1<<25)>>(word[i] - 'a'); // 25비트 밀어서 a부터 체크해놓고 알파벳 순서만큼 다시 오른쪽으로 밀기
			bit = bit | now; // 알파벳 체크
		}
		w.bit = bit;
		w.point = Integer.bitCount(bit);
	}

}
