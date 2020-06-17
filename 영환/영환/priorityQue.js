const priorityQue = (arr) =>{
    let heap = [""].concat(arr);
    let que = [];
    while(heap.length!==1){
        for(let i = heap.length -1 ; i >0 ; i--){
            if(heap[i]>heap[Math.floor(i/2)]){
                let tmp = heap[i];
                heap[Math.floor(i/2)] = heap[i];
                heap[i] = tmp;
            }
        }
        que.push(heap[1]);
        heap[1] = heap[heap.length-1];
        heap.pop();
    }
    return que;
}