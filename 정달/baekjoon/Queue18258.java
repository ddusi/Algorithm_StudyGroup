package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Queue18258 {

//    문제
//    정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//    명령은 총 여섯 가지이다.
//
//    push X: 정수 X를 큐에 넣는 연산이다.
//            pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//    size: 큐에 들어있는 정수의 개수를 출력한다.
//            empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//    입력
//    첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
//    주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
//
//            출력
//    출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        MyQue q = new MyQue();

        for(int i = 0 ; i < n ; i ++) {
            String[] param = br.readLine().trim().split(" ");
            q.translator(param);
        }
        System.out.println(q.b.toString());
    }
    public static class MyQue{
        public StringBuilder b;
        private int size;
        private Node front;
        private Node tail;

        private class Node{
            public Node next;
            public int data;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public MyQue(){
            this.b = new StringBuilder();
            this.size = 0;
            this.front = null;
            this.tail = null;
        }

        public void push(int input) {
            this.size ++;
            Node node = new Node(input);

            if(this.front == null) {
                this.front = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;

        }

        public int pop(){
            if(this.size > 0){
                Node out = this.front;
                this.front = out.next;
                this.size --;
                if(this.size<1) {
                    this.tail=null;
                }
                return out.data;
            }
            return -1;
        }

        public int size(){
            return this.size;
        }

        public int empty(){
            return size==0?1:0;
        }

        public int front(){
            return this.front==null?-1:this.front.data;
        }

        public int back(){
            return this.tail==null?-1:this.tail.data;
        }

        public void translator(String[] operand) {
                switch(operand[0]) {
                    case "push":
                        this.push( Integer.parseInt(operand[1]) );
                        break;
                    case "pop":

                        b.append(this.pop()).append('\n');
                        break;
                    case "size":
                        b.append(this.size()).append('\n');
                        break;
                    case "empty":
                        b.append(this.empty()).append('\n');
                        break;
                    case "front":
                        b.append(this.front()).append('\n');
                        break;
                    case "back":
                        b.append(this.back()).append('\n');
                        break;
                    default:
            }
        }
    }


}
