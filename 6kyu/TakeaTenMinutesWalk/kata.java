public class TenMinWalk {
  public static boolean isValid(char[] walk) {
        int topdown=0;
        int leftright=0;
        if(walk.length == 10 ){
            for(int i = 0; i < walk.length; i++){
                if(walk[i] == 'n'){
                    topdown++;
                }
                else if(walk[i] == 's'){
                    topdown--;
                } else if (walk[i] == 'w') {
                    leftright++;
                }
                else{
                    leftright--;
                }
            }
                      if(leftright == 0 && topdown == 0){
                              return true;          

            }
          else{
                        return false;    

          }
        }
        else{
            return false;    
        }
    
  }
}
