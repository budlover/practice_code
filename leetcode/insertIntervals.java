import java.util.ArrayList;


public class insertIntervals {
	public static void main(String args[]) {
		ArrayList<Interval> inter = new ArrayList<Interval>();

		inter.add(new Interval(1,5));

		Solution cl = new Solution();

		cl.insert(inter, new Interval(2, 7));

		for (Interval in : inter) {
			System.out.println(in.start + "   " + in.end);


		}

	}

}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i;
        Interval inter;
        Interval nextinter;
        
        if (intervals.size() == 0) {
			intervals.add(newInterval);
            return intervals;
		}
        
        for (i = 0; i < intervals.size(); i++) { // add new interval
            inter = intervals.get(i);
           
			System.out.println("for loop: " + inter.start + "  " + inter.end + "  " + newInterval.start + "  " + newInterval.end);

 
            if (inter.end >= newInterval.start) { //overlap
				
				System.out.println("add: " + inter.start + "  " + inter.end);

                inter.end = inter.end > newInterval.end ? inter.end : newInterval.end;
                inter.start = inter.start < newInterval.start ? inter.start : newInterval.start;
                break;
            }
        }
        
        for (i = 0; i < intervals.size() - 1; i++) {
            inter = intervals.get(i);
            nextinter = intervals.get(i + 1);
        
            if (inter.end <= nextinter.start) { // merge next interval
                inter.end = inter.end > nextinter.end ? inter.end : nextinter.end;
                inter.start = inter.start < nextinter.start ? inter.start : nextinter.start;
                intervals.remove(i + 1);
                i--;
            } else {
                ;
            }
        
        }
        
        return intervals;
        
    }
}
