package study.programmers.completeSearch;

import java.util.*;

//소수 찾기
//        문제 설명
//        한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//        각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
//        종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        numbers는 길이 1 이상 7 이하인 문자열입니다.
//        numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//        013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
//        입출력 예
//        numbers	return
//        17	3
//        011	2
//        입출력 예 설명
//        예제 #1
//        [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
//
//        예제 #2
//        [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
//
//        11과 011은 같은 숫자로 취급합니다.
//        출처
public class FindSosu {
    public int solution(String numbers)  {

        int answer = 0;
        int length = numbers.length();
        int[] intArray = new int[length];
        char[] charArray = numbers.toCharArray();
        for(int k = 0; k < length; k ++){
            intArray[k] = charArray[k] - 48;
        }

        String maxStr = "";
        Arrays.sort(intArray);
        for(int i = length-1; i >= 0; i--){
            maxStr += intArray[i]+"";
        }
        int maxNum = Integer.parseInt(maxStr);
        Set<Integer> set = getPrimeSets(maxNum);
        Set<Integer> comSet = new HashSet<>();
        for(int i = 1; i <= length; i ++) {
            int[] output = new int[i];
            boolean[] visited = new boolean[length];
            getPerm2(intArray, comSet, visited,output,0, length, i);
        }

        List<Integer> list = new LinkedList<>();
        int k = 0;
        for (Integer integer : comSet) {
            if(set.contains(integer)){
                k++;
            }
        }
        return k;
    }

    private Set<Integer> getPrimeSets(int num){
        // 모든 소수 구하기
        List<Integer> list = new LinkedList<>();
        list.add(2);
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i <= num; i ++) {

            boolean isPrime = true;
            double sqr = Math.sqrt(num);
            for(Integer k : list){
                if(i%k==0){
                    isPrime = false;
                    break;
                }
                if(k>sqr){
                    break;
                }
            }
            if(isPrime) list.add(i);
        }
        for(int a : list){
            set.add(a);
        }
        return set;
    }

    private void getPerm2(int[] a,Set<Integer> set,boolean[] visited, int[] output, int depth, int length, int r ){

        if(depth==r){
            set.add(Integer.parseInt(getStr(output)));
            return;
        }

        for(int i = 0; i < length; i ++ ){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = a[i];
                getPerm2(a, set, visited, output, depth+1, length, r);

                visited[i] = false;
            }
        }

    }

    private void getPerm(int[] a, Set<Integer> set, int depth, int length, int r){

        if(depth==r){
            set.add(Integer.parseInt(getStr(a)));
            return;
        }
        for(int i = depth ; i < length; i ++) {
            swap(a, depth, i);
            getPerm(a, set, depth+1,length, r);
            swap(a, depth, i);
        }
    }

    private String getStr(int[] ar){
        StringBuffer sb = new StringBuffer();
        for(int a : ar){
            sb.append(String.valueOf(a));
        }
        return sb.toString();
    }

    private void swap(int[] ar, int a, int b){
        int tmp = ar[a];
        ar[a] = ar[b];
        ar[b] = tmp;
    }

    public static void main(String[] args) throws Exception {
//        String answers = "73777";
//        System.out.println(new FindSosu().solution(answers));
        int[] a = {7,7,7,7,3};
        FindSosu s = new FindSosu();
        Set<Integer> comSet = new HashSet<>();
        for(int i = 1; i <= a.length; i ++) {
            int[] output = new int[i];
            boolean[] visited = new boolean[a.length];
            s.getPerm2(a, comSet, visited,output,0, a.length, i);
        }
        System.out.println(comSet);
    }
}
