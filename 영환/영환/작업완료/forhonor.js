function solution(n, results) {
    var answer = 0;
    let winRate = new Array(n+1);
    
    const winCh = (player,winner)=>{
        let tmpWinner = [].concat(winner);
        for(let i = 0 ; i < results.length ; i++){
            if(results[i][0]===player && tmpWinner.indexOf(results[i][1]) === -1){
                tmpWinner.push(results[i][1]);
                tmpWinner = winCh(results[i][1],tmpWinner);
            }
        }
        return tmpWinner;
    }
    const loseCh = (player,lose)=>{
        let tmpLose = [].concat(lose);
        for(let i = 0 ; i < results.length ; i++){
            if(results[i][1]===player && tmpLose.indexOf(results[i][0]) === -1){
                tmpLose.push(results[i][0]);
                tmpLose = loseCh(results[i][0],tmpLose);
            }
        }
        return tmpLose;
    }
    for(let i = 1 ; i <= n ; i++){
        winRate[i] = {
            win : winCh(i,[]),
            lose : loseCh(i,[]),
        }
    }
    for(let i = 1 ; i< winRate.length;i++){
        if(winRate[i].win.length + winRate[i].lose.length === n-1){
            answer++;
        }
    }
    return answer;
}