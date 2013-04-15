import java.util.ArrayList;

public class mergeIntervals {
	public static void main(String args[]) {
		ArrayList inter = new ArrayList<Interval>();

		inter.add(new Interval(0,2));

		inter.add(new Interval(2,3));
		inter.add(new Interval(4,4));

	}

}


class Interval {
     int start;
     int end;
    Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}



class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> newlist = new ArrayList<Interval>();
        if (intervals.size() == 0)
            return newlist;
        
        Interval inter = intervals.get(0);
        newlist.add(new Interval(inter.start, inter.end));
        
        int i;
        int j = 0;
        
        Interval merge;
        Interval check1;
        Interval check2;
        
        for (i = 1; i < intervals.size(); i++) {
            merge = intervals.get(i);
            inter = newlist.get(j);
            
            if (inter.end >= merge.start) { 
                if (inter.start > merge.end) {  // insert before 
                    newlist.add(j, new Interval(merge.start, merge.end));
                    j++;  
                    
                } else { // overlap
                    inter.end = inter.end > merge.end ? inter.end : merge.end;
                    inter.start = inter.start < merge.start ? inter.start : merge.start;
                }
            } else { // insert after
                newlist.add(new Interval(merge.start, merge.end));
                j++;
            }
            
            int k = j;
            for (k = j; k > 0; k--) { // check & merge previous intervals
                check1 = newlist.get(k);
                check2 = newlist.get(k - 1);
                
                if (check1.start > check2.end)
                    break;
                
                check2.start = check2.start < check1.start ? check2.start : check1.start;
                check2.end = check2.end > check1.end ? check2.end : check1.end;
                
                newlist.remove(k);
            }
        }
        
        return newlist;
        
    }
}
