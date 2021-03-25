package bj0325_맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static class Loc {
		int x,y;
		Loc(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[][] dist;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=0;t<test;t++) {
			n = Integer.parseInt(br.readLine())+2;
			ArrayList <Loc>list = new ArrayList<>();
			dist = new int[102][102];
			sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			init();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j) continue;
					Loc now = list.get(i);
					Loc next = list.get(j);
					int distance = Math.abs(now.x-next.x) + Math.abs(now.y - next.y);
					if(distance <=1000) {
						dist[i][j]=1;
					}
				}
			}
			floyd();
			getResult();
			System.out.println(sb);
		}
	}
	static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) continue;
				dist[i][j]=102;
			}
		}
	}
	static void floyd() {
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
					}
				}
			}
		}
	}
	static void getResult() {
		n=n-2;
		if(0<dist[0][n+1] && dist[0][n+1]<102) {
			sb.append("happy");
		}
		else {
			sb.append("sad");
		}
	}
}
