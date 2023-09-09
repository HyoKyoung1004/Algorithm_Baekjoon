class Solution {
    
    public long solution(int n, int[] times) {
     long answer = Long.MAX_VALUE;

        long start =1;
       long end = (long)Math.pow(10,18);
        //long end = 100;

        while(start<=end){

            long mid = (start+end)/2;
            long value = calN(times,mid);

            if(value >=n){
                answer = Math.min(answer, mid);
                end = mid-1;
            }else{ //value가 n보다 작으면 더 시간을 키워서 봐야해
                start = mid+1;
            }
        }

        return answer;
    }

    private static long calN(int[] times, long mid) {

        long num=0;
        for(int i=0;i<times.length;i++){
            num+=mid /times[i] ;
        }
        return num;

    }
    
}