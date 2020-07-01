
function solution(tmpinput){
    // var input = require('fs').readFileSync('/dev/stdin').toString().split("\n");
    const input = tmpinput.split("\n");
    let answer = 0;
    let totalWeight = 0;
    let stopWeight = 0;
    let inputs =[]
    for(i in input){
        inputs.push(input[i].trim().split(" "));
        Number(i)!==0? totalWeight += Number(inputs[inputs.length-1][0]):null;
    }
    // console.log(inputs,totalWeight);

    const cows = inputs.slice(1);
    const barnLocation = Number(inputs[0][1]);
    cows.sort((a,b)=> Number(a[1])-Number(b[1]));
    for(let time = 1 ; ; time++){
        // console.log("time = ",time)
        for(let i = 0 ; i<cows.length;i++){
            cows[i][1] = (cows[i][1]-0) + (cows[i][2]-0);
            if(i!==0 && cows[i-1][1]>cows[i][1]){ // 크로스 되었을경우
                let tmpLocation = cows[i-1][1];
                cows[i-1][1] = cows[i][1];
                cows[i][1] = tmpLocation;

                let tmpVelocity = cows[i-1][2];
                cows[i-1][2] = cows[i][2];
                cows[i][2] = tmpVelocity;

                answer ++;
            }else if(i!==0 && cows[i-1][1]===cows[i][1]){ // 지점에서 만났을경우
                let tmpVelocity = cows[i-1][2];
                cows[i-1][2] = cows[i][2];
                cows[i][2] = tmpVelocity;
            }

            if(cows[i][1]===0 || cows[i][1]===barnLocation){
                stopWeight+=(cows[i][0]-0);
                cows.splice(i,1);
            }
        }
        var aa = await res.data
        if(stopWeight >= totalWeight/2){
            // console.log(time);
            console.log(answer);
            break;
        }
    }
    return "not result";
}