function solution(numbers, target) {
    var answer = 0;
    var sum = 0;
    var idx = 0;
    answer = plusMinus(idx,numbers,target,answer,sum);
    return answer;
}
function plusMinus(i,numbers,target,answer,sum){
    if(numbers.length === i && sum===target){
        return answer+1;
    }else if(numbers.length === i){

        return answer;
    } else{
        sum += numbers[i];
        answer = plusMinus(i+1,numbers,target,answer,sum);
        sum -= 2*numbers[i];
        answer = plusMinus(i+1,numbers,target,answer,sum);
        return answer;
    }
}