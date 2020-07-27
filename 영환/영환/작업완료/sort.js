// selection sort 병합 퀵 힙 라딕스 +버블삽입선택

const selectSort=(array)=>{
    let arr = [].concat(array);
    for(let i = 0 ; i < arr.length ; i++){
        let min = arr[i];
        let minIdx = i;
        for(let j = i+1; j<arr.length ; j++){
            if(arr[j]<min){
                min = arr[j];
                minIdx = j;
            }
        }
        if(i!==minIdx){
            arr[minIdx] = arr[i];
            arr[i] = min;
        }
    }
    return arr;
} 


const insertSort =(array)=>{
    let arr = [];
    let tempArr = [];
    for(let i = 0 ; i < array.length ; i++){
        if(arr.length===0 || arr[arr.length-1]<array[i]){
            arr.push(array[i]);
        }else{
            while(arr[arr.length-1]>array[i]){
                tempArr.push(arr[arr.length-1]);
                arr.pop();
            }
            arr.push(array[i]);
            while(tempArr.length!==0){
                arr.push(tempArr[tempArr.length-1]);
                tempArr[tempArr.length-1].pop();
            }
        }
    }
    return arr;
}
 

const bubbleSort = (array) =>{
    let arr = [].concat(array);
    for(let count = 0 ; count < arr.length ; count++){
        for(let i = 1 ; i < arr.length-count ; i++){
            let temp;
            if(arr[i-1]>arr[i]){
                temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
            }
        }
    }
    return arr;
}

const mergeSort = (array) =>{
    let arr = new Array(array.length);
    for(let i = 0 ;  i < array.length ; i++){// initialize
        arr[i] = [].concat([array[i]]);
    }
    const log2 = Math.ceil(Math.log2(arrary.length));
    for (let i = 0 ; i < Math.ceil(log2) ; i++){
        const pow = Math.pow(2, i) 
        for(let n = 0; n<Math.ceil(array.length/(2*pow));n++){
            let firstArr = arr[pow*(2*n)];
            let secondArr = arr[pow*(2*n+1)];
            let tempArr = [];
            while(firstArr.length!==0||secondArr.length!==0){
                if(firstArr.length===0||firstArr[0]<=secondArr[0]){
                    tempArr.push(firstArr[0]);
                    firstArr.shift();
                }else{
                    tempArr.push(secondArr[0]);
                    secondArr.shift();
                }
            }
            arr[pow*(2*n)] = tempArr;
            arr[pow*(2*n+1)]= [];
        }
    }
    return arr[0];
}

/*
2406851739
2 4 0 6 8 5 1 7 3 9 
24 [] 06 [] 58 [] 17 [] 39 []
0246 [] [] [] 1578 [] [] [] 39 []
01245678 [] [] [] [] [] [] [] 39 []
*/


const heapSort = (array) =>{
    let arr = [0].concat(array);
    const length = array.length;
    let tempArr = [];
    const heapTreeCh = (idx)=>{
        //let left = arr[2*idx-1];
        //let right = arr[2*idx];
        if(2*idx<=length && arr[2*idx-1]<arr[idx-1]){
            let temp = arr[2*idx-1];
            arr[2*idx-1] = arr[idx-1];
            arr[idx-1] = temp;
            heapTreeCh(2*idx);
        }
        if(2*idx+1<=length && arr[2*idx]<arr[idx-1]){
            let temp = arr[2*idx];
            arr[2*idx] = arr[idx-1];
            arr[idx-1] = temp;
            heapTreeCh(2*idx+1);
        }
    }
    for(let i = 0 ; i < Math.floor(length/2) ; i++){//초기화
        heapTreeCh(i+1);
    }
    while( arr.length!==0){
        heapTreeCh(1);
        tempArr.push(arr[0]);
        arr.shift();
        arr = [arr[arr.length-1]].concat(arr);
        arr.pop();
    }
    return tempArr;
}
//0  1 2 3 4  5 6 7  8 9 
//1  2 3 4 5  6 7 8  9 10 11 12 
/*10 4 8 5 12 2 6 11 3 9  7  1 
10 - 4 8
4 - 5 12
8 - 2 6
5 - 11 3 
12 - 9 7
2  - 1   

10 
10 4 
10 4 8 
10 4 8 5 
10 5 8 4 
10 5 8 4 12 
10 12 8 4 5
12 10 8 4 5 
12 10 8 4 5 2
12 10 8 4 5 2 6
12 10 8 4 5 2 6 11
12 10 8 11 5 2 6 4
12 11 8 10 5 2 6 4 
12 11 8 10 5 2 6 4 3
12 11 8 10 5 2 6 4 3 9
12 11 8 10 9 2 6 4 3 5
12 11 8 10 9 2 6 4 3 5 7 
12 11 8 10 9 2 6 4 3 5 7 1
1 11 8 10 9 2 6 4 3 5 7 1 
*/



const quickSort = (array) =>{
    let arr = [].concat(array);
    const compare = (array) =>{
        let arr = [].concat(array);
        const midNum = arr[Math.floor(arr.length/2)];
        if(arr.length>2){
            let big,small;
            let tempbig = [];
            let tempsmall = [];
            for(let i = 0 ; i < arr.length; i++){
                if(i===Math.floor(arr.length/2)){
                    continue;
                }else if(arr[i]<=midNum){
                    tempsmall.push(arr[i]);
                }else{
                    tempbig.push(arr[i]);
                }
            }
            big = compare(tempbig);
            small = compare(tempsmall);
            small.push(midNum);
            return small.concat(big);
        }else{
            return arr;
        }
    }
    return compare(arr);
}



/*10 4 8 5 12 2 6 11 3 9  7  1 




*/