function solution(namechar) {
    //JEROEN	 56
    //JAN   23
     var answer = 0;
    let disp=Array.apply(null, new Array(namechar.length)).map(String.prototype.valueOf,"A");;
    const name = namechar.split("");
    //console.log('A'.charCodeAt(0)); 65
    //console.log('Z'.charCodeAt(0)); 90
    //console.log('K'.charCodeAt(0)); 
    
    
    const LR = (idx,arr) =>{
        let leftcount = 1 ,leftIdx=idx;
        let rightcount = 1, rightIdx=idx;
        let differ =true;
        while(differ){
            if(leftIdx===0){
                leftIdx = name.length-1;
            }else{
                leftIdx--;
            }
            if(JSON.stringify(arr) !== JSON.stringify(name) && arr[leftIdx] === name[leftIdx]){
                leftcount++;
            }else{
                differ = false;
            }
        }
        differ =true;
        while(differ){
            if(rightIdx>=name.length-1){
                rightcount = name.length;
                break;
            }else{
                rightIdx++;
            }
            if(arr[rightIdx] === name[rightIdx]){
                rightcount++;
            }else{
                differ = false;
            }
        }
        if(leftcount > rightcount){
            return [rightIdx,rightcount];
        }else{
            return [leftIdx,leftcount];
        }
    }
    const changeAlpha = (dispChar, nameChar) =>{
        const dispNum = dispChar.charCodeAt(0);
        const nameNum = nameChar.charCodeAt(0);
        let upcount = nameNum - dispNum;
        let downcount = 91 - nameNum;
        return Math.min(upcount,downcount);
        
    }
    let idx = 0 ; 
    while(1){
        answer += changeAlpha(disp[idx],name[idx]);
        disp[idx] = name[idx];
        if(JSON.stringify(disp) === JSON.stringify(name)){
            break;
        }
        let [newIdx,count] = LR(idx,disp);
        idx = newIdx;
        answer += count;
    }
    LR(idx,disp);
    return answer;
}