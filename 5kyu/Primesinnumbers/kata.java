import java.util.List;

public class PrimeDecomp {
   
    public static String factors(int n) {
    
      String ans = "";
      int count = 0;
      for(int i = 2; i <= n; i++ ){
        count = 0;
        while(n % i == 0){
          count++;
          n = n/i;
        }
        if(count == 1){
          ans += "(" + i + ")";
        }
        else if(count > 0){
          ans += "(" + i + "**" + count + ")";
        }
      }
      return ans;
    }
}
