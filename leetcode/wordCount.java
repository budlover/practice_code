public class wordCount {
	public static void main(String args[]) {
		String s = "w *() saf _ f ) i";
		System.out.println(wordcount(s));
	}



	private static int wordcount(String str) {
    	int i;
    	boolean startToCount = true;
    	int startindex = 0;
    	int count = 0;
 
    	for (i = 0; i < str.length(); i++) {
        	if (!Character.isLetter(str.charAt(i))) {           
               startToCount = true;  
        	} else {
             	if (startToCount == true) {             
                	startToCount = false;
                	count++;
            	}
        	}    
    	}
        
    	return count;
	}
}
