import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //
	static int N,M;
	static long[] subject;
	static long[] student;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		subject = new long[N];
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			long nowSubject=0;
			while(st.hasMoreTokens()) {
				int bit = Integer.parseInt(st.nextToken());
				nowSubject |= 1L<<bit;
			}
			subject[n]= nowSubject;
		}
		M = Integer.parseInt(br.readLine());
		student = new long[M];
		for(int m=0;m<M;m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			long nowStudent=0;
			while(st.hasMoreTokens()) {
				int bit = Integer.parseInt(st.nextToken());
				nowStudent |= 1L<<bit;
			}
			student[m]= nowStudent;
		}
		StringBuffer sb = new StringBuffer();
		for(int m=0;m<M;m++) {
			int result=0;
			for(int n=0;n<N;n++) {
				if(Long.bitCount(subject[n]) == Long.bitCount(subject[n]&student[m])) {
					result++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}

/*
public class bj14569 { //boolean 체크 코드
	static int N,M;
	static List<boolean[]> subject;
	static List<boolean[]> student;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		subject = new ArrayList<>();
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			boolean[] nowSubject= new boolean[51];
			while(st.hasMoreTokens()) {
				int bit = Integer.parseInt(st.nextToken());
				nowSubject[bit]=true;
			}
			subject.add(nowSubject);
		}
		M = Integer.parseInt(br.readLine());
		student = new ArrayList<>();
		for(int m=0;m<M;m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			boolean[] nowStudent= new boolean[51];
			while(st.hasMoreTokens()) {
				int bit = Integer.parseInt(st.nextToken());
				nowStudent[bit]= true;
			}
			student.add(nowStudent);
		}
		StringBuffer sb = new StringBuffer();
		for(int m=0;m<M;m++) {
			int result=0;
			loop: for(int n=0;n<N;n++) {
				for(int k=0;k<51;k++) {
					if(subject.get(n)[k]==true && student.get(m)[k]==false) {
						continue loop;
					}
				}
				result++;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
*/
