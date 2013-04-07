import java.util.ArrayList;

public class multiplyString {
	public static void main(String args[]) {
		String s1 = "42";
		String s2 = "10";

		Solution cl = new Solution();
		System.out.println(cl.multiply(s1, s2));
	}

}


class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        
        String up, down;
        int uplen, downlen;
        
        if (num1.length() <= num2.length()) {
            up = num2;
            uplen = num2.length();
            down = num1;
            downlen = num1.length();
        } else {
            up = num1;
            uplen = num1.length();
            down = num2;
            downlen = num2.length();
        }
        
        
        int go = 0;
        int mul;
        int maxsize = 0;
        int tmp;
 
        for (int i = downlen - 1; i >= 0; i--) {
            if (down.charAt(i) == '0')
                continue;
                
            ArrayList<Integer> list = new ArrayList<Integer>();
            
           	System.out.print("up: " +  up + "  down: " + down + "\n");


 
            for (int j = uplen - 1; j >=0 ; j--) {
                mul = (int)(up.charAt(j) - '0') * (int)(down.charAt(i) - '0');
                list.add(mul);
            }
            
            go = 0;
            for (int k = 0; k < list.size(); k++) {
                tmp = list.get(k) + go;
                list.set(k, tmp % 10);
                go = tmp / 10;
            }
            
            if (go > 0)
                list.add(go);
		

            for (int mm : list)
                System.out.print(" " + mm);
            System.out.println();
                
            lists.add(list);
        }
        
		// shift
		for (int i = 0; i < lists.size(); i++) {
			ArrayList<Integer> wawalist = lists.get(i);
			for (int j = 0; j < i; j++)
				wawalist.add(0, 0);

			if (wawalist.size() > maxsize)
                maxsize = wawalist.size();
		}


        // add 0 so that all list has same length
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() == maxsize)
                continue;
            
            ArrayList<Integer> tmplist = lists.get(i);
            for (int j = 0; j < maxsize - tmplist.size(); j++)
                tmplist.add(0);
        }
        
		
		/****
		for (ArrayList<Integer>lista : lists) {
		    System.out.println("*******************");
			for (int mm : lista)
                System.out.print(" " + mm);
            System.out.println();
		}
		******/


        ArrayList<Integer> res = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < maxsize; i++) {
            sum = 0;
            for (int j = 0; j < lists.size(); j++)
                sum += lists.get(j).get(i);
            
            res.add(sum);
        }
        
        go = 0;
        tmp = 0;
        for (int i = 0; i < res.size(); i++) {
            tmp = res.get(i) + go;
            res.set(i, tmp % 10);
            go = tmp / 10;
        }
        
        if (go > 0)
            res.add(go);
        
        String rets = "";
        
        for (int i = res.size() - 1; i >= 0; i--)
            rets += res.get(i);
        
        return rets;
    }
}
