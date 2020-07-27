function solution(n, edge) {
    //6,	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
    var answer = 0;
    let node = new Array(n);
    let visited = new Array(n);
    let check = [[1,0]] ;    
    let max;
    visited[0] = 0;
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
    console.log(node);
    while(check.length !== 0){
        let tempNode = check[0];
        check.shift();
        for(let i=0; i<node[tempNode[0]-1].length;i++){
            if(visited[node[tempNode[0]-1][i]-1]===undefined){
                check.push([node[tempNode[0]-1][i],tempNode[1]+1])
                visited[node[tempNode[0]-1][i]-1] = tempNode[1]+1;
            }
        }
        if(check.length===0){
            max = Math.max.apply(null, visited);
        }
    }
    for(let i = 0 ; i < visited.length ; i++){
        if(visited[i]===max){
            answer++;
        }
    }
    return answer;
}