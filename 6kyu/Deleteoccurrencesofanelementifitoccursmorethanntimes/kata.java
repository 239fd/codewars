import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class EnoughIsEnough {

	public static int[] deleteNth(int[] elements, int maxOccurrences) {
    int[] zeroArr = {};
    if(elements.length == 0 || maxOccurrences < 1) {
      return zeroArr;
    }
		  List<Integer> nums = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < elements.length; i++) {
            if(map.containsKey(elements[i])) {
                int count = map.get(elements[i]);
                map.put(elements[i], count + 1);

                if(count < maxOccurrences) {
                    nums.add(elements[i]);
                }
            }

            else {
                map.put(elements[i], 1);
                nums.add(elements[i]);
            }

        }

   
        Integer[] res = nums.toArray(new Integer[nums.size()]);
        return Arrays.stream(res).mapToInt(Integer::intValue).toArray();

	}

}
