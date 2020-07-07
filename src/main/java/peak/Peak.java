package peak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Peak {
    public static Map<String, List<Integer>> findPeak(int[] array) {

        Map<String, List<Integer>> result = new HashMap<>(){{
            put("pos",new ArrayList<>());
            put("peaks",new ArrayList<>());
        }};
        int peak = 1;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] >= array[i+1]){
                peak = i;
                while (array[i] == array[i+1] && i != array.length - 2){
                    i++;
                }
                if (array[i] > array[i+1]) {
                    result.get("pos").add(peak);
                    result.get("peaks").add(array[peak]);
                }
            }
        }
        return result;
    }

}
