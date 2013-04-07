public class Solution {
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        lists.add(new ArrayList<Integer>());
        
        ArrayList<ArrayList<Integer>> ret = recur(num, 0, lists);
        
        return ret;
        
    }
    
    private ArrayList<ArrayList<Integer>> recur(int num[], int index, ArrayList<ArrayList<Integer>> lists) {
        if (index >= num.length) {
            return lists;
        }
        
        ArrayList<ArrayList<Integer>> nextlists = new ArrayList<ArrayList<Integer>>();
        
        for(ArrayList<Integer> list : lists) {
            ArrayList<ArrayList<Integer>> newlists = insert(list, num[index]);
            nextlists.addAll(newlists);
        }
        
        ArrayList<ArrayList<Integer>> ret = recur(num, index+1, nextlists);
        
        return ret;
    }
    
    private ArrayList<ArrayList<Integer>> insert(ArrayList<Integer> inserted, int num) {
        int i;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        for(i = 0; i <= inserted.size(); i++) {
            ArrayList<Integer> newlist = (ArrayList<Integer>)inserted.clone();
            newlist.add(i, num);
            
            ret.add(newlist);
        }
        
        return ret;
    }
}
