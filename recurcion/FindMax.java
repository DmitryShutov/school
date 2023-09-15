package recurcion;

import java.util.ArrayList;

class FindMax {

    public static Integer secondMaxOfList(ArrayList<Integer> list) {
        if (list.size() < 2) {
            return null;
        }
        return findSecondMax(list, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private static Integer findSecondMax(ArrayList<Integer> list, int index, Integer max, Integer secondMax) {
        if (index == list.size()) {
            return secondMax;
        } 
        
        int next = list.get(index);
        if (next >= max) {
            secondMax = max;
            max = next;
        } else if (next > secondMax) {
            secondMax = next;
        }
    
        return findSecondMax(list, index + 1, max, secondMax);
    }
    
}
