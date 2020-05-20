package programmers.exercise.greedy;

import java.util.ArrayList;
import java.util.HashSet;

public class Camera {
    public static void main(String[] args) {
        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        int[][] tmp = new int[routes.length][2];
        // 시작점 기준으로 routes 배열 정렬
        merge2D(routes, tmp, 0, routes.length - 1, 0);

        int answer = 1; // 시작 시 단속 카메라 갯수
        int endCheck = routes[0][1]; // 기준점: 마지막 단속카메라의 위치
        for (int i = 1; i < routes.length; i++) {
            // 다음 라우트의 시작점이 기준점보다 클 경우, (현재까지의 단속 카메라로 새로운 라우트 단속 불가하다는 의미)
            // 기준점을 다음 라우트의 끝 점으로 갱신하고 카메라 숫자를 하나 증가시킨다.
            if(routes[i][0] > endCheck){
                answer++;
                endCheck = routes[i][1];
            }else{// 기준점을 현재 기준점과 다음 라우트의 끝 점 중 작은 값으로 갱신시킨다.
                endCheck = Math.min(endCheck, routes[i][1]);
            }
        }

        return answer;
    }

    /**
     * 주어진 orderIndex 기준으로 original 배열을 오름차순 정렬한다.
     * ex. {{1, 2}, {3, 1}, {2, 0}}
     *      orderIndex: 0 일 경우 정렬 결과 -> {{1, 2}, {2, 0}, {3, 1}}
     *      orderIndex: 1 일 경우 정렬 결과 -> {{2, 0}, {3, 1}, {1, 2}}
     * @param original
     * @param tmp
     * @param start
     * @param end
     * @param orderIndex
     */
    private static void merge2D(int[][] original, int[][] tmp, int start, int end, int orderIndex){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(original[start][orderIndex] > original[end][orderIndex]){
                int tmp1 = original[start][orderIndex];
                int tmp2 = original[start][1 - orderIndex];
                original[start][orderIndex] = original[end][orderIndex];
                original[start][1 - orderIndex] = original[end][1 - orderIndex];
                original[end][orderIndex] = tmp1;
                original[end][1 - orderIndex] = tmp2;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge2D(original, tmp, start, mid, orderIndex);
        merge2D(original, tmp, mid + 1, end, orderIndex);
        int left = start;
        int right = mid + 1;
        int index = start;
        while(left <= mid && right <= end){
            if(original[left][orderIndex] <= original[right][orderIndex]){
                tmp[index][orderIndex] = original[left][orderIndex];
                tmp[index][1 - orderIndex] = original[left][1 - orderIndex];
                left++;
            }else{
                tmp[index][orderIndex] = original[right][orderIndex];
                tmp[index][1 - orderIndex] = original[right][1 - orderIndex];
                right++;
            }
            index++;
        }
        if(left <= mid){
            while(index <= end){
                tmp[index][orderIndex] = original[left][orderIndex];
                tmp[index][1 - orderIndex] = original[left][1 - orderIndex];
                index++;
                left++;
            }
        }else{
            while(index <= end){
                tmp[index][orderIndex] = original[right][orderIndex];
                tmp[index][1 - orderIndex] = original[right][1 - orderIndex];
                index++;
                right++;
            }
        }
        for (int i = start; i <= end; i++) {
            original[i][orderIndex] = tmp[i][orderIndex];
            original[i][1 - orderIndex] = tmp[i][1 - orderIndex];
        }
    }
}
