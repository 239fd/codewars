import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * @author Marko Bekhta
 */
public class EnoughIsEnoughTest {
	
  
  private void doTest(int[] expected, int[] numbers, int count) {
    String msg = String.format("Incorrect answer for:\nelements=%s\nmaxOccurrences=%d", Arrays.toString(numbers), count);
    assertArrayEquals(msg, expected, EnoughIsEnough.deleteNth(numbers, count));
  }
  
  @Test
	public void deleteNth() throws Exception {
    
    doTest(new int[] { 20, 37, 21 }, new int[] { 20, 37, 20, 21 }, 1 );
		doTest(new int[] { 1, 1, 3, 3, 7, 2, 2, 2 }, new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 );
		doTest(new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 }, new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3 );
		doTest(new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1, 1 }, 5 );
		doTest(new int[] { }, new int[] { }, 5 );
	}

	@Test
	public void random() throws Exception {
		Random random = new Random();
		Map<Integer, Integer> cache = new HashMap<>();
		for ( int i = 0; i < 100; i++ ) {
			int maxOccurrences = random.nextInt( 10 );
			int size = random.nextInt( 100 );
			int[] testData = IntStream.generate( () -> random.nextInt( size ) ).limit( size ).toArray();
			int[] copyOfTestData = Arrays.copyOf( testData, testData.length );

			cache.clear();
			int[] expected = Arrays.stream( copyOfTestData )
            .filter( el -> cache.merge( el, 1, (a, b) -> a + b ) <= maxOccurrences )
            .toArray();

      doTest(expected, testData, maxOccurrences);
		}
	}
}
