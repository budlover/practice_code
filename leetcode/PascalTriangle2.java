public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if (0 == rowIndex) return list;
        
        int i, j;
        int pre = 0;
        int tmp = 0;
        
        for (i = 2; i <= rowIndex + 1; i++) {
            list.add(0);
            
            for (j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    list.set(j - 1, 1);
                    pre = 1;
                } else {
                    tmp = list.get(j - 1);
                    list.set(j - 1, pre + list.get(j - 1));
                    pre = tmp;
                }
            }
        }
        
        return list;
        
    }
}
