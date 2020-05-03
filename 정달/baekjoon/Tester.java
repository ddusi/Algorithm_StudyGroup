package study.baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Tester {

    public static void main(String[] args) throws IOException, InterruptedException {
        new Tester().stackArray1874Tester();
    }

    public void stackArray1874Tester() throws InterruptedException, IOException {



        Random r = new Random();
        StackArray1874 s = new StackArray1874();
        int case1 = 10;
        for(int i = 1; i <= 100000; i ++) {
            Set<Integer> set = new HashSet<Integer>();
            int[] array = new int[case1];
            int index = 0;
            while(true) {
                int n = r.nextInt(case1) + 1;

                boolean aa = set.add(n);
                if(aa){
                    array[index] = n;
                    index ++;
                }
                if(set.size()==case1){
                    break;
                }
                Thread.sleep(1);
            }
            System.out.println("----------------------- : " + case1 + "  " + i);
            System.out.println(Arrays.toString(array));
            s.run(case1, array);
            Thread.sleep(10);
        }


    }
}
