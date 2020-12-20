/**
 * **** Java自带快排
 */
import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length>=k&&k>0) {
            Arrays.sort(input);
            for(int i=0; i<k; i++) {
                result.add(new Integer(input[i]));
            }
        }
        return result;
    }
}

/**
 * **** Another Solve
 * **** Java PriorityQueue代替最大堆
 */

import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || k <= 0 || k > input.length) {
            return res;
        }
        // 重写，将最大堆变成最小堆
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        
        for (int i = 0; i < input.length; i++) {
            if(queue.size() < k) {
                queue.add(input[i]);
            }
            else {
                if(input[i] < queue.peek()) {
                    queue.remove();
                    queue.add(input[i]);
                }
            }
        }
        while(!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }
}

