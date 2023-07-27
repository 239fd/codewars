public class BitCounting {
	public static int countBits(int n){
    int a = n;
    int n1 = 0;
    String s = Integer.toBinaryString(a);
        char[] num = s.toCharArray();
        char one = '1' ;
        for(int i = 0; i < s.length(); i++){
            if(num[i] == one){
                n1++;
            }     
        }    
		return n1;
	}
}
