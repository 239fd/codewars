import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OutlierTest {
  @Test @DisplayName("Fixed tests") @Order(1)
  void fixedTests() {
/* Basic tests */
    int[] ints1 = {2,6,8,10,3}; //odd at the back
    int[] ints2 = {2,6,8,200,700,1,84,10,4}; //odd in the middle
    int[] ints3 = {17,6,8,10,6,12,24,36}; //odd in the front
    int[] ints4 = {2,1,7,17,19,211,7}; //even in the front
    int[] ints5 = {1,1,1,1,1,44,7,7,7,7,7,7,7,7}; //even in the middle
    int[] ints6 = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,35,5,5,5,5,5,5,5,5,5,5,7,7,7,7,1000}; //even at the end
    int[] ints7 = {2,-6,8,-10,-3}; //odd at the back, negative
    int[] ints8 = {2,6,8,2,-66,34,-35,66,700,1002,-84,10,4}; //odd in the middle, negative
    int[] ints9 = {-1* Integer.MAX_VALUE,-18,6,-8,-10,6,12,-24,36}; //odd in the front, negative
    int[] ints10 = {-20,1,7,17,19,211,7}; //even in the front, negative
    int[] ints11= {1,1,-1,1,1,-44,7,7,7,7,7,7,7,7}; //even in the middle, negative
    int[] ints12 = {1,0,0}; //odd answer, zeroes
    int[] ints13 = {3,7,-99,81,90211,0,7}; //even in the middle, zero
    int[] ints14 = {-5, -6, -7, -3, -11, -3, -9};
     
    assertEquals(3, FindOutlier.find(ints1));
    assertEquals(1, FindOutlier.find(ints2));
    assertEquals(17, FindOutlier.find(ints3));
    assertEquals(2, FindOutlier.find(ints4));
    assertEquals(44, FindOutlier.find(ints5));
    assertEquals(1000, FindOutlier.find(ints6));
    assertEquals(-3, FindOutlier.find(ints7));
    assertEquals(-35, FindOutlier.find(ints8));
    assertEquals(-1 * Integer.MAX_VALUE, FindOutlier.find(ints9));
    assertEquals(-20, FindOutlier.find(ints10));
    assertEquals(-44, FindOutlier.find(ints11));
    assertEquals(1, FindOutlier.find(ints12));
    assertEquals(0, FindOutlier.find(ints13));
    assertEquals(-6, FindOutlier.find(ints14));
  }
  
  @Test @DisplayName("Small random tests") @Order(2)
  void randomTests1() {
    for(int run = 0; run < 50; ++run)
      randomTest(50, 3, 10);
  }
  
  @Test @DisplayName("Medium random tests") @Order(3)
  void randomTests2() {
    for(int run = 0; run < 30; ++run)
      randomTest(50000, 300, 400);
  }
  
  @Test @DisplayName("Big random tests") @Order(4)
  void randomTests3() {
    for(int run = 0; run < 10; ++run)
      randomTest(5_000_000, 9_000_000, 10_000_000);
  }
  
  private void randomTest(int valueRange, int minSize, int maxSize) {
    var rnd = ThreadLocalRandom.current();
    int parity = rnd.nextBoolean() ? 1 : 0;
    var input = IntStream.generate(() -> 2 * rnd.nextInt(-valueRange, valueRange) + parity).limit(rnd.nextLong(minSize, maxSize)).toArray();
    int expected = 2 * rnd.nextInt(-valueRange, valueRange) + 1 + parity;
    input[rnd.nextInt(input.length)] = expected;
    assertEquals(expected, FindOutlier.find(input));
  }
}
