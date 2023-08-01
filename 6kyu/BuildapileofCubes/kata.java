public class ASum {
	
	public static long findNb(long m) {
		
  long count = 0L;
  long volume = 0L;
    
  while(volume < m){
    count += 1;
    volume += count*count*count; 
  }
  if(volume == m){
    return count;
  }
    else {
        return -1;
      }
	}	
}
