import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCase=getTestCase(); //테스트케이스 몇개인지 입력받는다.
		String [][][]array=new String[testCase][][];
		for(int i=0;i<testCase;i++) //테스트 케이스만큼 Array에 입력받는다.
		{
			int arraySize=getArraySize();
			array[i]=getArray(arraySize);
		}
		for(int i=0;i<testCase;i++)
		{
			getResult(array[i],i+1); //결과출력
		}

	}
	public static int getTestCase() throws NumberFormatException, IOException {
		return Integer.parseInt(br.readLine());
	}
	public static int getArraySize() throws NumberFormatException, IOException {
		return Integer.parseInt(br.readLine());
	}
	public static String[][] getArray(int size) throws IOException {
		String [][] array=new String[size][size];
		int count=0;
		for(int i=0;i<size;i++)
		{
			count=0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
			{
				array[i][count++]=st.nextToken();
			}
		}
		return array;
	}
	public static void getResult(String[][] array,int resultNum) {
		int i,j;
		int max=0;
		int value=0;
		for(i=0;i<array[0].length;i++)
		{
			for(j=0;j<array[0].length;j++)
			{
				if(array[i][j].equals("G"))
					continue;
				if(lookAround(i,j,array))
				{
					value=getHeight(i,j,array); //건물높이 계산
					max=(max>value)?max:value;  //최대 높이 저장
				}
			}
		}
		System.out.println("#"+resultNum+" "+max); //결과 출력
		
	}
	public static boolean lookAround(int i,int j,String[][]array)
	{
		if(leftSide(i,j,array)&&rightSide(i,j,array)&&upSide(i,j,array)&&downSide(i,j,array)&&leftUpSide(i,j,array)&&leftDownSide(i,j,array)&&rightUpSide(i,j,array)&&rightDownSide(i,j,array))
			return true;
		else 
			return false;
	}
	public static boolean leftSide(int i,int j,String[][] array) //좌
	{
		if(j==0||array[i][j-1].equals("B"))
			return true;
		else 
			return false;
	}
	public static boolean rightSide(int i,int j,String[][] array) //우
	{
		if(j==array[0].length-1||array[i][j+1].equals("B"))
			return true;
		else 
			return false;
	}
	public static boolean upSide(int i,int j,String[][] array) //상
	{
		if(i==0||array[i-1][j].equals("B"))
			return true;
		else 
			return false;
	}
	public static boolean downSide(int i,int j,String[][] array) //하
	{
		if(i==array[0].length-1||array[i+1][j].equals("B"))
			return true;
		else 
			return false;
	}
	public static boolean leftUpSide(int i,int j,String[][] array) //좌상
	{
		if(i==0||j==0||array[i-1][j-1].equals("B"))
			return true;
		else 
			return false;
	}
	public static boolean leftDownSide(int i,int j,String[][] array) //좌하
	{
		if(i==array[0].length-1||j==0||array[i+1][j-1].equals("B"))
			return true;
		else 
			return false;
	}
	public static boolean rightUpSide(int i,int j,String[][] array) //우상
	{
		if(i==0||j==array[0].length-1||array[i-1][j+1].equals("B"))
			return true;
		else 
			return false;
	}
	public static boolean rightDownSide(int i,int j,String[][] array) //우하
	{
		if(i==array[0].length-1||j==array[0].length-1||array[i+1][j+1].equals("B"))
			return true;
		else 
			return false;
	}
	public static int getHeight(int i,int j,String[][] array) //건물 높이 계산
	{
		int height=0;
		int idx=i;
		int jdx=j;
		while(jdx>=0)
		{
			if(array[idx][jdx--].equals("B"))
				height++;
		}
		idx=i;jdx=j;
		while(jdx<array[0].length)
		{
			if(array[idx][jdx++].equals("B"))
				height++;
		}
		idx=i;jdx=j;
		while(idx>=0)
		{
			if(array[idx--][jdx].equals("B"))
				height++;
		}
		idx=i;jdx=j;
		while(idx<array[0].length)
		{
			if(array[idx++][jdx].equals("B"))
				height++;
		}
		return height-3;
	}
}
