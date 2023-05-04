import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14888 {
    static int N,max,min;
    static int [] nums;
    static int [] opers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = -1000000000;
        min = 1000000000;
        nums = new int[N];
        opers = new int[4]; // {+,-,*,/}
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while(st.hasMoreTokens()){
            nums[index++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        index = 0;
        while(st.hasMoreTokens()){
            opers[index++] = Integer.parseInt(st.nextToken());
        }
        getResult(1,opers,nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void getResult(int index,int[] state, int result){
        if(index == N){
            max = Math.max(max, result);
            min = Math.min(min,result);
            return;
        }
        if(state[0] > 0){
            getResult(index+1, new int[] {state[0]-1,state[1],state[2],state[3]},result + nums[index]);
        }
        if(state[1] > 0){
            getResult(index+1, new int[] {state[0],state[1]-1,state[2],state[3]},result - nums[index]);
        }
        if(state[2] > 0){
            getResult(index+1, new int[] {state[0],state[1],state[2]-1,state[3]},result * nums[index]);
        }
        if(state[3] > 0){
            getResult(index+1, new int[] {state[0],state[1],state[2],state[3]-1},result / nums[index]);
        }
    }
}
