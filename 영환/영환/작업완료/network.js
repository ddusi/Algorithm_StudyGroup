function solution(n, computers) {
    var answer = 0;
    var visited = new Array(n);
    for(let i = 0 ; i < n ;i++){
        if(visited[i]){
        }else{
            answer++;
            visit(i);
        }
    }
    function visit (i){
        if(!visited[i]){
            visited[i] = true;
            for(let j = 0; j< computers[i].length ;j++){
                if(i!==j&&computers[i][j]===1){
                    visit(j);
                }
            }
        }else{return;}
    }
    return answer;
}