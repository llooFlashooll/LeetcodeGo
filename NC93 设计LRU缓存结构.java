import java.util.*;


public class Solution {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    // 涉及到使用LinkedHashMap<>，可以实现LRU
    public int[] LRU (int[][] operators, int k) {
        // write code here
        LinkedHashMap<Integer, Integer> lruMap = new LinkedHashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList();
        
        for(int[] opat: operators) {
            int key = opat[1];
            switch(opat[0]) {
                case 1:
                    int value = opat[2];
                    if(lruMap.size() < k) {
                        lruMap.put(key, value);
                    }
                    else {
                        Iterator ot = lruMap.keySet().iterator();
                        lruMap.remove(ot.next());
                        lruMap.put(key, value);
                    }
                    break;
                case 2:
                    if(lruMap.containsKey(key)) {
                        int val = lruMap.get(key);
                        result.add(val);
                        lruMap.remove(key);
                        lruMap.put(key, val);
                    }
                    else {
                        result.add(-1);
                    }
                    break;
                default:
            }
        }
        
        // 要求返回int[]数组，而不是ArrayList<>数组
        int[] resultArr = new int[result.size()];
        int i = 0;
        for(int a: result) {
            resultArr[i++] = a;
        }
        return resultArr;
    }
}