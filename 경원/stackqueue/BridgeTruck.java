package programmers.exercise.stackqueue;

import java.util.LinkedList;

public class BridgeTruck {
    public static void main(String[] args) {
//        int[] truck_weight = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] truck_weight = {2, 2, 2, 2, 1, 1, 1, 1, 1};
        System.out.println(solution(5, 5, truck_weight));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Integer> trucks = new LinkedList<>();
        LinkedList<Boolean> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            bridge.offer(false);
        }

        int totalWeightInBridge = 0;
        int time = 0;
        for(int i = 0; i < truck_weights.length; i++){
            boolean isIthTruckInBridge = false;
            while(totalWeightInBridge + truck_weights[i] > weight || trucks.size() == bridge_length){
                if(bridge.peek()){
                    totalWeightInBridge -= trucks.poll();
                    if(totalWeightInBridge + truck_weights[i] <= weight){
                        trucks.offer(truck_weights[i]);
                        totalWeightInBridge += truck_weights[i];
                        bridge.offer(true);
                        isIthTruckInBridge = true;
                    }else{
                        bridge.offer(false);
                    }
                    bridge.poll();
                    time++;
                    if(isIthTruckInBridge){
                        break;
                    }else{
                        continue;
                    }
                }
                bridge.poll();
                bridge.offer(false);
                time++;
            }
            if(!isIthTruckInBridge){
                trucks.offer(truck_weights[i]);
                totalWeightInBridge += truck_weights[i];
                bridge.offer(true);
                if(bridge.peek()){
                    totalWeightInBridge -= trucks.poll();
                }
                bridge.poll();
                time++;
            }
        }
        if(trucks.size() != 0){
            int index = 1;
            while(!bridge.isEmpty()){
                if(bridge.getLast()){
                    time += (bridge_length - index + 1);
                    break;
                }else{
                    index++;
                }
                bridge.removeLast();
            }
        }
        return time;
    }
}
