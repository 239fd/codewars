import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.Random;

public class DuplicateEncoderTest {

public String makeWord(){
  String testWord = "";
  String charSet = "abcdefghijklMNOPQRSTUVWXYZ1234567890)(*&^% `<>?/}{+=";
  Random r = new Random();
  for (int i = 0; i < r.nextInt(10)+1; i++){
    testWord = testWord += charSet.charAt(r.nextInt(charSet.length()));
  }
  return testWord;
}

String e(String word){
    word = word.toLowerCase();
    String result = "";
    for (int i = 0; i < word.length(); ++i) {
      char ch = word.charAt(i);
      if (word.lastIndexOf(ch) == word.indexOf(ch)){
        result = result.concat("(");
        } else {
        result = result.concat(")");
    }}
    return result;
  }
    @Test
    public void test() {

    String[] randomTests = {makeWord(), makeWord(),makeWord(),makeWord(),
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), 
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), 
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
    makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord()};

   for (String test : randomTests) {
     assertEquals(e(test), DuplicateEncoder.encode(test));
    }
   
   
      assertEquals(")()))()))))()(",
            DuplicateEncoder.encode("Supralapsarian"));
      assertEquals(")))))(",DuplicateEncoder.encode(" ( ( )"));
      assertEquals("((((", DuplicateEncoder.encode("walk"));
      assertEquals("))))))", DuplicateEncoder.encode("Hannah"));
      assertEquals("))(", DuplicateEncoder.encode("$$\\"));
      assertEquals("(", DuplicateEncoder.encode("|"));
      
    }
}
