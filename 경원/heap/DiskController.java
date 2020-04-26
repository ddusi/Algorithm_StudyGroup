package programmers.exercise.heap;

public class DiskController {
    public static void main(String[] args) {
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs = {{0,3},{4,4},{5,3},{4,1}};
//        int[][] jobs = {{0, 3}, {1, 9}, {500, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        merge2D(jobs, 0, jobs.length - 1);
        MinHeap heap = new MinHeap(jobs.length);
        int time = jobs[0][0];
        int index = 0;
        // 하나의 job에 대한 완료 시점마다 그 동안의 요청 job들 heap에 insert
        // 그 중 최소 소요 시간인 job을 처리
        while(index < jobs.length || heap.getSize() > 0){
            // 현재 시간까지 요청 들어온 job (이미 처리한 job 제외)에 대해 heap에 insert
            while(index < jobs.length && (jobs[index][0] <= time || heap.getSize() == 0)){
                // time을 지금 넣을 job에 맞춰야 됨
                if(heap.getSize() == 0 && time < jobs[index][0]){
                    time = jobs[index][0];
                }
                Job job = new Job(jobs[index][0], jobs[index][1]);
                heap.insert(job);
                index++;
            }
            //가장 짧은 요청 시간의 job을 처리
            Job priority = heap.delete();
            time += priority.required;
            answer += (time - priority.request);
        }

        return answer / jobs.length;
    }

    public static void merge2D(int[][] arr, int start, int end){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(arr[start][0] > arr[end][0]){
                int tmp1 = arr[start][0];
                int tmp2 = arr[start][1];
                arr[start][0] = arr[end][0];
                arr[start][1] = arr[end][1];
                arr[end][0] = tmp1;
                arr[end][1] = tmp2;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge2D(arr, start, mid);
        merge2D(arr, mid + 1, end);
        int[][] tmpArr = new int[arr.length][2];
        int index = start;
        int k = start;
        int l = mid + 1;
        while(k <= mid && l <= end){
            if(arr[k][0] > arr[l][0]){
                tmpArr[index][0] = arr[l][0];
                tmpArr[index][1] = arr[l][1];
                l++;
            }else{
                tmpArr[index][0] = arr[k][0];
                tmpArr[index][1] = arr[k][1];
                k++;
            }
            index++;
        }
        if(k > mid){
            while(l <= end){
                tmpArr[index][0] = arr[l][0];
                tmpArr[index][1] = arr[l][1];
                l++;
                index++;
            }
        }else{
            while(k <= mid){
                tmpArr[index][0] = arr[k][0];
                tmpArr[index][1] = arr[k][1];
                k++;
                index++;
            }
        }
        for(int i = start; i <= end; i++){
            arr[i] = tmpArr[i];
        }
    }

    private static class Job{
        public int request; // 요청 시간
        public int required; // 소요 시간
        public Job(int request, int required){
            this.request = request;
            this.required = required;
        }
    }

    private static class MinHeap{
        private Job[] jobs;
        private int size;

        public MinHeap(int n){
            jobs = new Job[n + 1];
            size = 0;
        }

        public void insert(Job job){
            jobs[++size] = job;
            for(int i = size; i > 1; i /= 2){
                if(jobs[i].required < jobs[i / 2].required){
                    Job tmp = jobs[i];
                    jobs[i] = jobs[i / 2];
                    jobs[i / 2] = tmp;
                }else{
                    break;
                }
            }
        }

        public Job delete(){
            Job ans = jobs[1];
            jobs[1] = jobs[size--];
            for(int i = 1; i * 2 <= size; ){
                if(jobs[i].required < jobs[i * 2].required
                        && jobs[i].required < jobs[i * 2 + 1].required){
                    break;
                }
                if(jobs[i * 2].required < jobs[i * 2 + 1].required){
                    Job tmp = jobs[i];
                    jobs[i] = jobs[i * 2];
                    jobs[i * 2] = tmp;
                    i = i * 2;
                }else{
                    Job tmp = jobs[i];
                    jobs[i] = jobs[i * 2 + 1];
                    jobs[i * 2 + 1] = tmp;
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
