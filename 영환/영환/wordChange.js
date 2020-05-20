function solution(begin, target, words) {
    var answer = 0;
    let instanceWords = words.filter(word => word!==begin);
    let newWords = [begin].concat(instanceWords);
    var visited = new Array(newWords.length);
    var que = [];
    if(words.indexOf(target)===-1){
        return 0;
    }else{
        const visitNode = (node,time) => {
            for(let i = 0 ; i<newWords.length;i++ ){
                let differ = 0;
                if(!visited[i]){
                    for(let j = 0; j<newWords[i].length;j++){
                        if(node[j]!==newWords[i][j]){differ++;};
                    }
                    if(differ===1 && newWords[i] === target){
                        visited[i] = true;
                        que.push({word:newWords[i],times :time +1,prevWords:node});
                        return time+1;
                    }else if(differ===1){
                        visited[i] = true;
                        que.push({word:newWords[i],times :time +1,prevWords:node});
                    }
                }
            }
        };
        for(let i = 0 ; que.length !== newWords.length && i<newWords.length;i++){
            if(i===0){
                visited[0]=true;
                que.push({word:begin, times :0,prevWords:""}); 
            }
            const tmp = visitNode(que[i].word,que[i].times);
             if(tmp!==undefined){
                 return tmp;
             };
        }
        console.log(que);
        for(let i = 0 ; i<que.length;i++){
            if(que[i].word === target){
                return que[i].times;
            }
        }
        return answer;
    }
}