        //제출용
    //     var fs = require('fs');
    //     var input = require('fs').readFileSync('/dev/stdin').toString().split(" ");
        
    //     //본 code
    // console.log(Number(input[0])+Number(input[1]));




    function solution(tmpinput){
        // var input = require('fs').readFileSync('/dev/stdin').toString().split("\n");
        const input = tmpinput.split("\n");
        let answer = "";

        let inputs =[]
        for(v of input){
            inputs.push(v.trim().split(" "))
        }
        const node = Number(inputs[0][0]);
        const friends = Number(inputs[0][1]);
        const farmMilk = inputs[1][0].split("");
        const vertax = inputs.slice(2,2+node-1);
        const needs = inputs.slice(1+node);
        
        console.log(friends,farmMilk,vertax,needs);        
        let graph = new Array(node+1);
        for(let i = 0 ; i < vertax.length ; i++){
            graph[Number(vertax[i][0])]===undefined? graph[Number(vertax[i][0])]=[Number(vertax[i][1])]:graph[Number(vertax[i][0])].includes(Number(vertax[i][1]))? null:graph[Number(vertax[i][0])].push(Number(vertax[i][1]));
            graph[Number(vertax[i][1])]===undefined? graph[Number(vertax[i][1])]=[Number(vertax[i][0])]:graph[Number(vertax[i][1])].includes(Number(vertax[i][0]))? null:graph[Number(vertax[i][1])].push(Number(vertax[i][0]));
        }

        for(let i = 0; i<needs.length ; i++){
            let disArr =[Number(needs[i][0])]; // 경로 입력용 배열
            let tmpArr = new Array(node+1); // visit체크를 위한 배열
            let tmp = findRoute(disArr,tmpArr,Number(needs[i][1]));
            let happy = "0";
            for(v of tmp){
                if(farmMilk[v-1]===needs[i][2]){
                    happy = "1";
                    break;
                }
            }
            answer+=happy;
        }
        
        function findRoute(disArr, visitArr, target){
            const nowNode = disArr[disArr.length-1];
            let returnVal = []; 
            if(nowNode === target){
                return disArr;
            }
           for(i in graph[nowNode]){
                let tmpVisit = [].concat(visitArr);
                tmpVisit[nowNode] = true;
                if(tmpVisit[graph[nowNode][i]]!== true){
                    let tmpdis = [].concat(disArr);
                    tmpdis.push(graph[nowNode][i]);
                    let tmp = findRoute(tmpdis,tmpVisit,target);
                    tmp.length !== 0? returnVal = tmp :null;
                }
            }
            return returnVal;

        }
        console.log(answer);
        
        return answer;
    }
