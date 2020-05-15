function solution(tickets) {
    var answer = [];
    var used = new Array(tickets.length);
    tickets.sort(function(a, b) { // 도착지로 정렬
      if (a[1] < b[1]) {return -1;}
      else if (a[1] > b[1]) {return 1;}
      else{return 0;}
    });
    const trip = (ticketNum,answer,used) =>{
        let use = [].concat(used);
        use[ticketNum]= true;
        let newAnswer = [].concat(answer);
        newAnswer.push(tickets[ticketNum][1]);
        console.log(ticketNum,newAnswer,use);
        if(newAnswer.length===tickets.length+1){
            return newAnswer;
        }else{
            for(let i = 0 ; i<tickets.length ; i++){
                if(!use[i] && newAnswer[newAnswer.length-1]===tickets[i][0]){
                    let distanceAnswer = trip(i,newAnswer,use);
                    if(distanceAnswer.length===tickets.length+1){
                        newAnswer= distanceAnswer;
                    }
                }
            }
        }
        return newAnswer;
    }
    for(let i = 0 ; i<tickets.length ; i++){
        if(tickets[i][0]==="ICN"){
            answer = ["ICN"]
            answer = trip(i,answer,used);
        }
        if(answer.length===tickets.length+1){
            return answer;
        }
    }
}