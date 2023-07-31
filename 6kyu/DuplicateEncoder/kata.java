public class DuplicateEncoder {
	static String encode(String word){
  
    String[] list,list2 = new String[word.length()];
		list = word.toLowerCase().split("");
		String result = "";
		
		
		for(int i=0; i<list.length; i++)
		{
			for(int j=i+1; j<list.length; j++) 
			{
				if(list[i].equalsIgnoreCase(list[j])) 
				{
					list2[i] = ")";
					list2[j] = ")";
				}
			}
		}

		for(int k=0; k<list2.length; k++) 
		{
			if(list2[k]!=")") {
				list2[k]="(";
				result += list2[k];
			}
			else
				result += list2[k];
		}
		
	    return result;
  }
}
