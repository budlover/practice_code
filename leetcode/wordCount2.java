public class wordCount2 {
	public static void main(String args[]) {
		String s = "1 asdffasd sdfsdf sadf$asd sdf#d     ";

		System.out.println(wordcount(s));
	}

	private static int wordcount(String str) {
    	int i;
    	boolean startToCount = false;
    	int count = 0;
 
    	for (i = 0; i < str.length(); i++) {
        	if(!Character.isLetter(str.charAt(i))) {
            	if (startToCount == true) {
                	startToCount = false;
                	count++;
            	}
        	} else {
            	startToCount = true;  
        	}    
    	}
    
    	if (startToCount == true)
        	count++;
        
    	return count;
	}

}
