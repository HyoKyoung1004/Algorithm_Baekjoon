class Solution {
    public int[] solution(int brown, int yellow) {
        //int x=0, y=0;
        int[] answer = new int[2];

        double total = (double)(brown+yellow);
        for(int i=3 ;i<=1000000;i++){
            double x = (brown+4)/2 -i;
            if(total ==(x*i)){
                answer[0] = (int)x;
                answer[1]=i;
                break;
            }
            
        }
        return answer;
    }
}