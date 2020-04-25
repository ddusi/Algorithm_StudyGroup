class Solution {
    public int[] solution(int[] heights) {
        int towerNum = heights.length;
        int[] answer = new int[towerNum];
        
        //answer[0] = 0;
        for(int i = towerNum-1; i > 0; i--){
            for(int j = i-1; j >= 0; j--){
                if(heights[j] > heights[i]){
                    answer[i] = j + 1;
                    break;
                }
            }                        
        }
        
        return answer;
    }
}
