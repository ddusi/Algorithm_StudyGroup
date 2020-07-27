function solution(tmpinput){
    const input = tmpinput.split("\n");
    let answer = 0;

    let inputs =[]
    for(v of input){
        inputs.push(v.trim().split(" "))
    }
    // console.log(inputs);
    const XCount = Number(inputs[0][0]);
    const Ycount = Number(inputs[XCount+1][0]);
    let ArrX={},ArrY ={},partialSumY = {} ,idxY = [];
    for(let i = 0 ; i < XCount; i++){
        ArrX[inputs[1+i][0]] = Number(inputs[1+i][1]);
        ArrY[inputs[XCount+ 2+i][0]] =  Number(inputs[XCount+ 2+i][1]);
        idxY.push(Number(inputs[XCount+ 2+i][0]));
        partialSumY[inputs[XCount+ 2+i][0]] = i !== 0 ? partialSumY[inputs[XCount+ 2+i-1][0]]+ Number(inputs[XCount+ 2+i][1]): Number(inputs[XCount+ 2+i][1]);
    }
    const StartCons = Number(inputs[XCount+Ycount+2][0]);
    const FinalCons = Number(inputs[XCount+Ycount+3][0]);
    // console.log(StartCons,FinalCons,ArrX,ArrY,partialSumY,idxY);
    function findIdx (Arr, value,startidx,lastidx){
        // console.log(value,startidx,lastidx);
        if(value < Arr[startidx]){return -1};
        if(value === Arr[startidx] || (Arr[startidx] < value && Arr[startidx+1] > value) || lastidx === startidx+1){
            return Arr[startidx];
        }else if(value === Arr[lastidx] || Arr[lastidx] < value){
            return Arr[lastidx];
        }else{
            let newIdx = Math.floor((startidx + lastidx)/2);
            if(Arr[newIdx] === value){
                return Arr[newIdx];
            }else if(Arr[newIdx] > value ){
                
                return findIdx(Arr, value, newIdx,lastidx);
            }else{
                return findIdx(Arr, value, startidx, newIdx);
            }
        }
    }
    for(i in ArrX){
        let nowIdx = Number(i);
        let startIdx = nowIdx + StartCons;
        if(startIdx < 0){
            startIdx = 0;
        }
        let lastIdx = nowIdx + FinalCons;
        if(lastIdx > 1000000000){
            lastIdx = 1000000000;
        }
        // console.log(startIdx,lastIdx);

        let newStart = findIdx(idxY,lastIdx, 0 , idxY.length-1);
        let newLast = findIdx(idxY,startIdx-1, 0 , idxY.length-1);
        // console.log(newStart,newLast);
        let sumY = newLast === -1? partialSumY[newStart]  :partialSumY[newStart] -  partialSumY[newLast];
        answer += ArrX[i]*sumY;
        // console.log("ansewr",answer,sumY);

    }
    console.log(answer)


    return answer;
}