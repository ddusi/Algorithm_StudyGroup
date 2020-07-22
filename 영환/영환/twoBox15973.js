function solution(tmpinput) {
    // var input = require('fs').readFileSync('/dev/stdin').toString().split("\n");
    const inputs = tmpinput.split("\n");
    
    const  disoord1 = inputs[0].trim().split(" ");
    const disoord2 = inputs[1].trim().split(" ");
    const rectangle1 = [[Number(disoord1[0]),Number(disoord1[1])],[Number(disoord1[0]),Number(disoord1[3])],
    [Number(disoord1[2]),Number(disoord1[1])],[Number(disoord1[2]),Number(disoord1[3])]]
    const rectangle2 = [[Number(disoord2[0]),Number(disoord2[1])],[Number(disoord2[0]),Number(disoord2[3])],
    [Number(disoord2[2]),Number(disoord2[1])],[Number(disoord2[2]),Number(disoord2[3])]]

    console.log(inputs);
    console.log(rectangle1,rectangle2);
    console.log(disoord1[0],disoord2[0],disoord1[2],disoord2[2]);
    if(Number(disoord1[0]) > Number(disoord2[2]) || Number(disoord2[0]) > Number(disoord1[2])){
        console.log("11");
        if(Number(disoord1[1]) > Number(disoord2[3]) || Number(disoord2[1]) > Number(disoord1[3])){
            return "face";
        }else if(Number(disoord1[1]) === Number(disoord2[3]) || Number(disoord2[1]) === Number(disoord1[3])){
            return "line";
        }else{return "null";};
    }else if(Number(disoord1[0]) === Number(disoord2[2]) || Number(disoord2[0]) === Number(disoord1[2])){
        console.log("22");
        if(Number(disoord1[1]) > Number(disoord2[3]) || Number(disoord2[1]) > Number(disoord1[3])){
            return "line";
        }else if(Number(disoord1[1]) === Number(disoord2[3]) || Number(disoord2[1]) === Number(disoord1[3])){
            return "point";
        }else{return "null";};
    }else{return "null";};
     
    




    return "not yet!"
}