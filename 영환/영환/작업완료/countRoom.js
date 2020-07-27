function solution(arrows) {
    //[6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0]
    // console.log(solution([6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0]));
    // console.log(solution([5,2,7,2,5,0]));
    // console.log(solution([6, 5, 2, 7, 1, 4, 2, 4, 6]));
    // console.log(solution( [5, 2, 7, 1, 6, 3]));
    //console.log(solution( [6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0]));
    //[5,2,7,2,5,0] [6, 5, 2, 7, 1, 4, 2, 4, 6] [5, 2, 7, 1, 6, 3] [6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0] 답은 모두 3입니다.
    
    var answer = 0;
    let nodeHistory ={};
    let edgeHistory ={};
    let x = 0, y=0;
    const move = (x,y,direction) =>{
        if(direction===0){
            y++;
        }else if(direction===1){
            x++;
            y++;
        }else if(direction===2){
            x++;
        }else if(direction===3){
            x++;
            y--;
        }else if(direction===4){
            y--;
        }else if(direction===5){
            x--;
            y--;
        }else if(direction===6){
            x--;
        }else if(direction===7){
            x--;
            y++;
        }
        return [x,y];
    }
    for(let i = 0 ; i < arrows.length ; i++){
        const coord = move(x,y,arrows[i]);
        const lastNode = [x,y];
        const newNode = coord;
        if(nodeHistory[JSON.stringify(newNode)] === 1){
            if(edgeHistory[JSON.stringify([lastNode,newNode])]!==1){
               answer ++;
            }
        }
        if(arrows[i]%2 === 1){
            let tempkiddy1= [x,coord[1]];
            let tempkiddy2= [coord[0],y];
            if(edgeHistory[JSON.stringify([tempkiddy1,tempkiddy2])]===1 && edgeHistory[JSON.stringify([lastNode,newNode])]!==1){
                answer++;
            }
        }
        nodeHistory[JSON.stringify(lastNode)] =1;
        edgeHistory[JSON.stringify([lastNode,newNode])] =1;
        edgeHistory[JSON.stringify([newNode,lastNode])] =1;
        [x,y] = newNode;
    }
    return answer;
}