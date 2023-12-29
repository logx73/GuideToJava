package Collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQue {
    public static void main(String[] args) {
        int[] nums = {1,5,3,7,2,8,4};
        Comparator<Integer> comparator = (num1,num2)->{
            return num2-num1;
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(comparator);
        for (int n:nums) {
            priorityQueue.add(n);
            if (priorityQueue.size() > 4)
                priorityQueue.poll();
        }

    }
}
