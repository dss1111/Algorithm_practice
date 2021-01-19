import java.util.PriorityQueue;
class Solution {
    public class Job implements Comparable<Job>{
        int start;
        int end;
        int value;
        public Work(start,value){
            this.start=start;
            this.value=value;
        }
        @Override
        public int compareTo(Job target) {
            if (this.value > target.value) {
                return 1;
            } else if (this.value < target.value) {
                return -1;
            }
            return 0;
        }
    }
    public int solution(int[][] jobs) {
            Arrays.sort(jobs,(o1,o2)->o1[0] - o2[0]); //오름차순
            PriorityQueue <Job>pq = new PriorityQueue<Job>();
            PriorityQueue<Job>q=new PriorityQueue<Job>();
            int time=0;
            int complete=0; //완료된 작업수
            for(int i=0;i<jobs.length;i++)
            {
                Job j=new Job(jobs[i][0],jobs[i][1]);
                pq.offer(j);
            }
            while(!pq.isEmpty())
            {
                pq.peek();
            }
            return 0;
    }
}
