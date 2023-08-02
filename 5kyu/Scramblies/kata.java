import java.util.HashMap;
import java.util.Map;

public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {   
      if(str2 == null || str2.length() == 0){
        return true;
      }
       HashMap<Character, Integer> s1 = new HashMap<>();
       HashMap<Character, Integer> s2 = new HashMap<>();
      
      for(char c : str1.toCharArray()){
        char cur = Character.toLowerCase(c);
        s1.put(cur, s1.getOrDefault(cur, 0) + 1);
      }
      for(char c : str2.toCharArray()){
        char cur = Character.toLowerCase(c);
        s2.put(cur, s2.getOrDefault(cur, 0) + 1);
      }
      for( Map.Entry<Character, Integer> entry : s2.entrySet()){
        try{
          if(entry.getValue() > s1.get(entry.getKey())){
            return false;
          }
        } catch (NullPointerException e){
          return false;
        }
      }
      return true;
    }
}
