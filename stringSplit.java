import java.util.Stack;
import java.util.Arrays;

public class stringSplit {
	public static void main(String args[]) {
		Solution cl = new Solution();
		String s= "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
		System.out.println(cl.simplifyPath(s));

	}
} 



class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below

        // DO NOT write main() function
        String arr[] = path.split("/");
        Stack<String> st = new Stack<String>();


        //System.out.println(Arrays.toString(arr) + "\n");



        for(String s : arr) {
            if (s.equals("."))
                continue;
            else if (s.equals(""))
                continue;
            else if (s.equals("..")) {
                if (!st.empty())
                    st.pop();
                else
                    continue;
            } else
                st.push(s);
        }

        if (st.empty())
            return "/";

        String ret = "";
        while (!st.empty()) {
            String out = st.pop();

            //System.out.print(out + " ");


            if (out.equals(""))
                continue;

            out = "/" + out;
            ret = out + ret;
        }

        if (ret.equals(""))
            ret = "/";

        return ret;
    }

}
