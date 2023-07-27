public class Kata {
  public static String createPhoneNumber(int[] numbers) {
   return '(' + Integer.toString(numbers[0]) + Integer.toString(numbers[1]) + Integer.toString(numbers[2]) + ')' + " " + Integer.toString(numbers[3]) + Integer.toString(numbers[4]) + Integer.toString(numbers[5]) + "-" + Integer.toString(numbers[6]) + Integer.toString(numbers[7]) + Integer.toString(numbers[8]) + Integer.toString(numbers[9]); 
  }
}
