function solution(n, results) {
    var answer = 0;
    let winRate =[];
    for(let i = 0 ; i < n ; i++){ // initialize
        let temp = new Array(n);
        temp[i]=0;
        winRate.push(temp);
    }

    for(var i in results){
        winRate[results[i][0]-1][results[i][1]-1]= 1;
    }
    console.log([].concat(winRate))

    for(let i = 0 ; i  < n ; i++){
        for(let j = 0 ; j < n ; j++){
            for(let k = 0; k < n ; k++){
                
                if(winRate[i][j]===undefined){winRate[i][j]=101;}
                if(winRate[i][k]===undefined){winRate[i][k]=101;}
                if(winRate[k][j]===undefined){winRate[k][j]=101;}
                if(winRate[i][j] > winRate[i][k]+winRate[k][j]){
                    winRate[i][j]=winRate[i][k]+winRate[k][j];
                }
            }
        }
    }

    console.log([].concat(winRate))









    // for(let i = 0 ; i < results.length ; i ++ ){
    //     let winner = results[i][0];
    //     let loser = results[i][1];
    //     if(winRate[winner-1]===undefined){
    //         winRate[winner-1] = {
    //             win : [loser],
    //             lose : [],
    //         }
    //     }else{
    //         winRate[winner-1]==={
    //             ...winRate[winner-1],
    //             win: winRate[winner-1].win.push(loser)
    //         }
    //     }
        
    //     if(winRate[loser-1]===undefined){
    //         winRate[loser-1] = {
    //             win : [],
    //             lose : [winner],
    //         }
    //     }else{
    //         winRate[loser-1]==={
    //             ...winRate[loser-1],
    //             win: winRate[loser-1].win.push(winner)
    //         }
    //     }
    // }// winner lose 분류
    
    // const findWinner = (number,winlist) =>{ // 
    //     let winner = [].concat(winRate[number-1].win);
    //     let tempList = [].concat(winlist);
    //     for(let i = 0 ; i < winner.length ; i++){
    //         if(tempList.indexOf(winner[i])===-1){
    //             tempList.push(winner[i]);
    //             tempList = findWinner(winner[i],tempList);
    //         }
    //     }
    //     return tempList;
    // }
    
    // const findLoser = (number,loselist) =>{ // 
    //     let loser = [].concat(winRate[number-1].lose);
    //     let tempList = [].concat(loselist);
    //     for(let i = 0 ; i < loser.length ; i++){
    //         if(tempList.indexOf(loser[i])===-1){
    //             tempList.push(loser[i]);
    //             tempList = findLoser(loser[i],tempList);
    //         }
    //     }
    //     return tempList;
    // }
    
    // for(let i = 0 ; i < winRate.length ; i++){
    //     let winner = [].concat(winRate[i].win);
    //     let loser = [].concat(winRate[i].lose);
    //     if(winRate[i].win.length + winRate[i].lose.length === n-1){
    //         continue;
    //     }else{
    //         for(let j = 0; j < winRate[i].win.length;j++){
    //             winner = findWinner(winRate[i].win[j],winner);
    //         }
            
    //         for(let j = 0; j < winRate[i].lose.length;j++){
    //             winner = findLoser(winRate[i].lose[j],loser);
    //         }
    //     }
    // }

    console.log(winRate)
    return answer;
}