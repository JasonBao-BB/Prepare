import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 取最大的第K个 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4};

        int n = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        Set<Integer> nums = new HashSet<>();

        for(int num : arr) {
            if(nums.contains(num)) {
                continue;
            }
            pq.offer(num);
        }

        while(n != 0) {
            pq.poll();
            n--;
        }

        System.out.println(pq.peek());
    }
}

