import java.util.Arrays;

public class Kata {
  public static int findEvenIndex(int[] arr) {
    int result = -1;
            for (int i = 0; i <= arr.length - 1; i++) {
                int[] left = new int[i], right = new int[(arr.length - 1) - i];
                System.arraycopy(arr, 0, left, 0, i);
                System.arraycopy(arr, i + 1, right, 0, (arr.length - 1) - i);
                if (getSumOfArray(left) == getSumOfArray(right)) {
                    result = i;
                    break;
                }
            }
            return result;
    }
    private static int getSumOfArray(int[] arr) {
        return Arrays.stream(arr).sum();
    }
  }
