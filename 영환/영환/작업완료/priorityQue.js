const priorityQue = (arr,conditionFn) =>{
    let heap = [""].concat(arr);
    let que = [];
    if(typeof conditionFn !== "function" ){
        conditionFn = function(a,b){
            return a>b;
        }
    }
    while(heap.length!==1){
        for(let i = 2 ; i <heap.length ; i++){
            if(conditionFn(heap[i],heap[Math.floor(i/2)])){
                queChange(heap,i,conditionFn);
            }
        }
        que.push(heap[1]);
        heap[1] = heap[heap.length-1];
        heap.pop();
    }
    return que;
}
const queChange = (arr,idx,conditionFn)=>{
    const newIdx = Math.floor(idx/2);
    let tmp = arr[idx];
    arr[idx] = arr[newIdx];
    arr[Math.floor(idx/2)] = tmp;
    if(newIdx !==1 && conditionFn(arr[newIdx],arr[Math.floor(newIdx/2)])){
        queChange(arr,newIdx,conditionFn);
    }
}

// 사용법 배열을 1번째 변수에 넣고 두번째는 두개를 비교하여 참이되는 조건을 넣으면 된다. 
// 함수 default값은 a>b === 큰거 우선