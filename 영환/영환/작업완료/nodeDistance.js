function solution(n, edge) {
    var answer = [];
    let node = new Array(n);
    let visited = new Array(n);    
    for (let i =  0; i < edge.length; i++){
        const firstNode = edge[i][0] - 1;
        const secondNode = edge[i][1] - 1;
        if(node[firstNode]===undefined){
            node[firstNode] = [secondNode+1];
        }else if(node[firstNode].indexOf(secondNode+1)===-1){
            node[firstNode] = node[firstNode].concat([secondNode+1]);
        }
        if(node[secondNode]===undefined){
            node[secondNode] = [firstNode+1];
        }else if(node[secondNode].indexOf(firstNode+1)===-1){
            node[secondNode] = node[secondNode].concat([firstNode+1]);
        }
    }
    const findDistance = (idx,visited)=>{
        let tempVisit = [].concat(visited);
        let min = {
            visitCount:0,
            distance : n,
            idx:0};
        tempVisit[idx-1].visit = true;
        for(let i = 0 ; i < node[idx-1].length ; i++){
            if(tempVisit[node[idx-1][i]-1]===undefined || 
                (tempVisit[node[idx-1][i]-1].visit ===false &&
               tempVisit[node[idx-1][i]-1].distance > tempVisit[idx-1].distance + 1)){
                tempVisit[node[idx-1][i]-1]={
                    distance : tempVisit[idx-1].distance + 1,
                    visit : false,
                    root : idx
                };
            }
        }
        
        for(let i = 0 ; i < tempVisit.length ;i++){
            if(tempVisit[i]!== undefined && tempVisit[i].visit ===false && tempVisit[i].distance<min.distance){
                min.distance = tempVisit[i].distance;
                min.idx = i;
            }
            if(tempVisit[i] !== undefined && tempVisit[i].visit){
                min.visitCount++;
            }
        }
        if(min.visitCount !== n){
            tempVisit = findDistance(min.idx+1,tempVisit);
        }
        return tempVisit;
    }
    visited[0]={
        distance : 0,
        visit : false,
        root : 0,
    };
    visited = findDistance(1,visited);
    console.log(visited);
    visited.sort((a,b) =>b.distance-a.distance);
    console.log(visited);
    for(let i = 0 ; i <visited.length ; i ++){
        if(answer.length === 0 || answer[answer.length-1].distance === visited[i].distance){
            answer = answer.concat([visited[i]])
        }else{
            break;
        }
    
    }
    console.log(answer);
    return answer.length;
}