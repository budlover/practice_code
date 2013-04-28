public class threesum {
	public static void main(String args[]) {
		Solution cl = new Solution();
		
		int arr[] = {1,2,3,-4,5};

		cl.threeSum(arr);	

	}

}

class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        
        if (num.length == 0) return list;
        
        Arrays.sort(num);
        int i;
        
        for (i = 0; i < num.length - 2; i++) {
            int ret[] = twosum(num, i+1, ((-1)*num[i]));
            
            if (null != ret) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(num[i]);
                list.add(ret[0]);
                list.add(ret[1]);
                lists.add(list);
                
                
            }
            
            
        }
        
        
        return lists;
    }
    
    private int[] twosum(int[] num, int start, int sum) {
        if (start >= num.length - 1) return null;
        int l = start;
        int r = num.length - 1;
        int arr[] = new int[2];
        
        while (l < r) {
            if (num[l] + num[r] == sum) {
                arr[0] = num[l];
                arr[1] = num[r];
                
                return arr;
            }
            
            if (num[l] + num[r] < sum) l++;
            else r--;
        }
        
        return null;
    }
}
