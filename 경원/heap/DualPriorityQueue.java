package programmers.exercise.heap;

public class DualPriorityQueue {
    public static void main(String[] args) {
//        String[] operations = {"I 7","I 5","I -5","D -1"};
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        int[] ans = solution(operations);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        MinHeap minHeap = new MinHeap(operations.length);
        MaxHeap maxHeap = new MaxHeap(operations.length);

        int insertN = 0; // 삽입 횟수
        int deleteMinN = 0; // 최솟값 제거 횟수
        int deleteMaxN = 0; // 최댓값 제거 횟수
        for(String str : operations){
            String[] split = str.split(" ");
            int num = Integer.parseInt(split[1]);

            // 비었을 경우
            if(insertN == deleteMaxN + deleteMinN || maxHeap.getSize() == 0 || minHeap.getSize() == 0){
                minHeap = new MinHeap(operations.length);
                maxHeap = new MaxHeap(operations.length);
            }
            if("I".equals(split[0])){
                minHeap.insert(num);
                maxHeap.insert(num);
                insertN++;
            }else{
                if(num == 1){
                    if(insertN != deleteMaxN + deleteMinN){
                        maxHeap.delete();
                        deleteMaxN++;
                    }
                }else{
                    if(insertN != deleteMaxN + deleteMinN){
                        minHeap.delete();
                        deleteMinN++;
                    }
                }
            }
        }

        if(insertN == deleteMaxN + deleteMinN || maxHeap.getSize() == 0 || minHeap.getSize() == 0){
            return answer;
        }
        answer[0] = maxHeap.delete();
        answer[1] = minHeap.delete();

        return answer;
    }

    private static class MinHeap{
        private int[] arr;
        private int size;

        public MinHeap(int n){
            arr = new int[n + 1];
            size = 0;
        }

        public void insert(int num){
            arr[++size] = num;
            for(int i = size; i > 1; i /= 2){
                if(arr[i] < arr[i / 2]){
                    int tmp = arr[i];
                    arr[i] = arr[i / 2];
                    arr[i / 2] = tmp;
                }else{
                    break;
                }
            }
        }

        public int delete(){
            int ans = arr[1];
            arr[1] = arr[size--];
            // 왼쪽 자식 노드만 살아 있을 경우에 대한 예외처리 추가
            for(int i = 1; i * 2 <= size; ){
                if(arr[i] < arr[i * 2] && (i * 2 + 1 > size || arr[i] < arr[i * 2 + 1])){
                    break;
                }
                if(arr[i * 2] < arr[i * 2 + 1] || i * 2 + 1 > size){
                    int tmp = arr[i];
                    arr[i] = arr[i * 2];
                    arr[i * 2] = tmp;
                    i = i * 2;
                }else{
                    int tmp = arr[i];
                    arr[i] = arr[i * 2 + 1];
                    arr[i * 2 + 1] = tmp;
                    i = i * 2 + 1;
                }
            }
            return ans;
        }

        public int getSize(){
            return size;
        }
    }

    private static class MaxHeap{
        private int[] arr;
        private int size;

        public MaxHeap(int n){
            arr = new int[n + 1];
            size = 0;
        }

        public void insert(int num){
            arr[++size] = num;
            for(int i = size; i > 1; i /= 2){
                if(arr[i] > arr[i / 2]){
                    int tmp = arr[i];
                    arr[i] = arr[i / 2];
                    arr[i / 2] = tmp;
                }else{
                    break;
                }
            }
        }

        // 왼쪽 자식 노드만 살아 있을 경우에 대한 예외처리 추가
        public int delete(){
            int ans = arr[1];
            arr[1] = arr[size--];
            for(int i = 1; i * 2 <= size; ){
                if(arr[i] > arr[i * 2] && (i * 2 + 1 > size || arr[i] > arr[i * 2 + 1])){
                    break;
                }
                if(arr[i * 2] > arr[i * 2 + 1] || i * 2 + 1 > size){
                    int tmp = arr[i];
                    arr[i] = arr[i * 2];
                    arr[i * 2] = tmp;
                    i = i * 2;
                }else{
                    int tmp = arr[i];
                    arr[i] = arr[i * 2 + 1];
                    arr[i * 2 + 1] = tmp;
                    i = i * 2 + 1;
                }
            }
            return ans;
        }

        public int getSize(){
            return size;
        }
    }
}
