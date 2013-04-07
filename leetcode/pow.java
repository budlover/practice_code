public class pow {
	public static void main(String args[]){
		Solution cl = new Solution();

		System.out.println(cl.pow(2.50, 2));

	}

}

class Solution {
    double pow(double x, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n == 0)
            return 1;
        
        if (x == 0)
            return 0;
        
        int i;
        double res = 1;
        
        if (n > 0) {
            for (i = 0; i < n; i++) {
                res *= x;
            }
        } else {
            for (i = 0; i < n; i++) {
                res /= x;
            }
        }
        
        return res;
    }
}
