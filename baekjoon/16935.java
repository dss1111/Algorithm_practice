import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			getResult(Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				sb.append(arr[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void getResult(int num) {
		if(num==1) {
			int[][] result = new int[N][M];
			for(int i=0;i<N;i++) {
				result[i]=arr[N-i-1];
			}
			arr = result;
		}
		if(num==2) {
			int[][] result = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					result[i][j]=arr[i][M-j-1];
				}
			}
			arr = result;
		}
		if(num==3) {
			int temp=M;
			M=N;
			N=temp;
			int[][] result = new int[N][M];
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++) {
					result[i][j] = arr[M-1-j][i];
				}
			}
			arr = result;
		}
		if(num==4) {
			int temp=M;
			M=N;
			N=temp;
			int[][] result = new int[N][M];
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++) {
					result[i][j] = arr[j][N-1-i];
				}
			}
			arr = result;
		}
		if(num==5) {
			int[][] a1=new int[N/2][M/2];
			int[][] a2=new int[N/2][M/2];
			int[][] a3=new int[N/2][M/2];
			int[][] a4=new int[N/2][M/2];
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					a1[i][j]=arr[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					a2[i][j]=arr[i][j+M/2];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					a4[i][j]=arr[i+N/2][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					a3[i][j]=arr[i+N/2][j+M/2];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					arr[i][j]=a4[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					arr[i][j+M/2]=a1[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					arr[i+N/2][j]=a3[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					arr[i+N/2][j+M/2]=a2[i][j];
				}
			}
		}
		if(num==6) {
			int[][] a1=new int[N/2][M/2];
			int[][] a2=new int[N/2][M/2];
			int[][] a3=new int[N/2][M/2];
			int[][] a4=new int[N/2][M/2];
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					a1[i][j]=arr[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					a2[i][j]=arr[i][j+M/2];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					a3[i][j]=arr[i+N/2][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					a4[i][j]=arr[i+N/2][j+M/2];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					arr[i][j]=a2[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					arr[i][j+M/2]=a4[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					arr[i+N/2][j]=a1[i][j];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					arr[i+N/2][j+M/2]=a3[i][j];
				}
			}
		}
	}
}
