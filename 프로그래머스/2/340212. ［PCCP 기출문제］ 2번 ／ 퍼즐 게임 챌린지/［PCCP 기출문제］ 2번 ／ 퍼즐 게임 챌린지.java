class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int  maxDiff= 300000;

       answer = binarySearch(maxDiff, diffs, times, limit);
        
        return answer;
    }
    
    private int binarySearch(int maxDiff, int[] diffs, int[] times, long limit){
        
        
        int minLevel = 1;
        int maxLeverl= maxDiff;
        int resultLevel = 1;
        
        while(minLevel<= maxLeverl){
            //중간레벨
            int midLevel = (minLevel+maxLeverl)/2;
            
            //중간레벨로 구한 총 소요시간
            long durationTime = getTime(diffs, times, midLevel);
            System.out.println(midLevel+", "+durationTime);
            
            if(durationTime>limit){
                //이 레벨가지고는 안됨, 레벨을 좀더 놓여봐야함
                minLevel = midLevel+1;
            }else{
                //더 작은 레벨을 봐야함
                resultLevel =  midLevel;
                maxLeverl = midLevel-1;
                
            }
            
        }
        return resultLevel;
        
    }
    
    private long getTime(int[] diffs, int[] times, int level){
        long resultTime=0;
       
        for(int i=0;i<diffs.length;i++){
            
            if(diffs[i]<=level) resultTime+= (long)times[i];
            else{
                resultTime+= (long)(diffs[i]-level)*(times[i]+times[i-1])+times[i];
                
            }
            
        }
        return resultTime;
    }
    
}