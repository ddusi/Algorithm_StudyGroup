function solution(number, k) {
    var answer = '';
    let numArr = number.split("");
    let delCount = 0;
    let max;
    let stack = [];
    for(let i = 0 ;i<numArr.length; i++){
        if(stack.length === 0 ){
            stack.push(numArr[i]);
            max = numArr[i];
        }else if(stack[stack.length-1] < numArr[i] && delCount<k){
            stack.pop();
            delCount++;
            i--;
        }else if(i===numArr.length-1&&  delCount<k){
            stack.push(numArr[i]);
            for(;delCount<k;){
                stack.pop();
                delCount++;
            }
        }else{
            stack.push(numArr[i]);
        }

    }
    answer = stack.join("");
    return answer;
}