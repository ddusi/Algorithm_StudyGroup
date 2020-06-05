package programmers.exercise.heap;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        MinHeap heap = new MinHeap(scoville.length);
        for(int num : scoville){
            heap.insert(num);
        }
        while(heap.getSize() >= 2 && heap.getRoot() < K){
            int firstNonSpicy = heap.delete();
            int secondNonSpicy = heap.delete();
            answer++;
            heap.insert(firstNonSpicy + secondNonSpicy * 2);
        }

        if(heap.getRoot() < K){
            return -1;
        }

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
            for(int i = 1; i * 2 <= size; ){
                int highPriority = Math.min(arr[i * 2], arr[i * 2 + 1]);
                if(arr[i] < highPriority){
                    break;
                }
                if(arr[i * 2] < arr[i * 2 + 1]){
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

        public int getRoot(){
            return arr[1];
        }

        public int getSize(){
            return size;
        }
    }
}
