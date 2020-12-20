import java.util.*;

/**
 * 经典
 */
public class Solution {
    /**
     * 
     * @param numbers int整型一维数组 
     * @param target int整型 
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int n = numbers.length;
        int[] result = new int[2];
        // 利用HashMap实现
        // map里面放 键为target-每个数的结果 值为下标
        // 每次放入若包含当前值，则可以得出结果
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<n; i++) {
            if(map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
                break;
            }
            else {
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }
}