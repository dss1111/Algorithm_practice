package bj2021_08_09_DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj9019 {
	static int T;
	static int start,end;
	static class Node implements Comparable<Node>{
		int step;
		int number;
		String orders;
		Node(int step,int number,String orders){
			this.step = step;
			this.number = number;
			this.orders = orders;
		}
		@Override
		public int compareTo(Node o) {
			return this.step - o.step;
		}
	}
	static boolean []visit;
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			visit = new boolean[10001];
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			getResult();
		}
		System.out.println(result);
	}
	static void getResult() {
		PriorityQueue <Node>pq = new PriorityQueue<>();
		pq.add(new Node(0,start,""));
		visit[start] = true;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.number == end) {
				result.append(now.orders).append("\n");
				return;
			}
			int next = orderD(now.number);
			if(!visit[next]) {
				pq.add(new Node(now.step+1,next,now.orders+"D"));
				visit[next] = true;
			}
			next = orderS(now.number);
			if(!visit[next]) {
				pq.add(new Node(now.step+1,next,now.orders+"S"));
				visit[next] = true;
			}
			
			next = orderL(now.number);
			if(!visit[next]) {
				pq.add(new Node(now.step+1,next,now.orders+"L"));
				visit[next] = true;
			}
			
			next = orderR(now.number);
			if(!visit[next]) {
				pq.add(new Node(now.step+1,next,now.orders+"R"));
				visit[next] = true;
			}
		}
	}
	static int orderD(int number) {
		int next = number * 2;
		if(next>9999) return next % 10000;
		else return next; 
	}
	static int orderS(int number) {
		int next = number -1;
		if(next==-1) return 9999;
		else return next;
	}
	static int orderL(int number) {
		int next = (number%1000)*10 + number/1000;
		return next;
	}
	static int orderR(int number) {
		int next = (number%10)*1000+(number/10);
		return next;
	}
}
