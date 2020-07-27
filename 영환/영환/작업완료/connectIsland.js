function solution(n, costs) {
    //4,[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
    var answer = 0;
    let connected = [];
    let bridgeCosts = [].concat(costs)
    bridgeCosts.sort((a,b)=>a[2]-b[2]);
    let i = 0;
    console.log([].concat(bridgeCosts));
    while(connected.length !== n){
        // if(connected.indexOf(bridgeCosts[0][0]) !== -1 || connected.indexOf(bridgeCosts[0][1]) !== -1){
        //     connected.indexOf(bridgeCosts[0][0]) === -1 ? connected.push(bridgeCosts[0][0]):{};
        //     connected.indexOf(bridgeCosts[0][1]) === -1 ? connected.push(bridgeCosts[0][1]):{};

        // }
        
        console.log("i = " , i ,answer, connected , bridgeCosts)
        if(connected.length === 0 ){
            connected.push(bridgeCosts[0][0]);
            connected.push(bridgeCosts[0][1]);
            answer += bridgeCosts[0][2];
            bridgeCosts.shift();
        }else if((connected.includes(bridgeCosts[i][0]) && !connected.includes(bridgeCosts[i][1]))||(!connected.includes(bridgeCosts[0][0]) && connected.includes(bridgeCosts[0][1]))){
            !connected.includes(bridgeCosts[i][0])? connected.push(bridgeCosts[i][0]):{};
            !connected.includes(bridgeCosts[i][1])? connected.push(bridgeCosts[i][1]):{};
            answer += bridgeCosts[i][2];
            bridgeCosts.splice(i,1);
            i = 0;
        }else{
            i++;
        }

    }
    console.log(answer,);

    return answer;
}