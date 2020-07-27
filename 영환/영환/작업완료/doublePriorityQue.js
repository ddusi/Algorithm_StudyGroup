function solution(operations) {
    var answer = [];
    for(let i = 0 ; i < operations.length ; i++){
        let input = operations[i].trim().split(" ");
        if(input[0] === "I"){
            answer.push(Number(input[1]));
            answer.sort((a,b) => a-b);
        }else if(Number(input[1])>0){
            answer.pop();
        }else{
            answer.shift();
        }
    }
    return answer.length === 0? [0,0]:[answer[answer.length-1],answer[0]];
}