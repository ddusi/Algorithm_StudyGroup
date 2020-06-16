function solution(arrangement) {
    var answer = 0;
    let stick = 0; 
    for(let i = 0 ; i < arrangement.length; i++){
        if(arrangement[i]==="("){
            stick++;
        }else{
            stick--;
            if(arrangement[i-1]==="("){
                answer+=stick;
            }else{
                answer++;
            }
        }
    }
    
    return answer;
}