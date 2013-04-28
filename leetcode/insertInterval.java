import java.lang.Math;
import java.util.ArrayList;

public class insertInterval {
	public static void main(String args[]) {
		Solution cl = new Solution();
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,5));
		list.add(new Interval(6,8));

		cl.insert(list, new Interval(5,6));

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
        if (0 == intervals.size()) {
            intervals.add(newInterval);
            return intervals;
        }
        
        int i;
        boolean flag = false;
        
        for (i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > newInterval.end) {
                intervals.add(i, newInterval);
                return intervals;
            } else if (intervals.get(i).end < newInterval.start) { // no mathch
                continue;
            } else {  // merge here
                intervals.get(i).start = Math.min(intervals.get(i).start, newInterval.start);
                intervals.get(i).end = Math.max(intervals.get(i).end, newInterval.end);
                break;
            }
        }
        
        if (i == intervals.size() - 1) return intervals;
        
        if (i >= intervals.size()) { // add at last
            intervals.add(intervals.size(), newInterval);
            return intervals;
        }
        
        if (intervals.get(i).end >= intervals.get(i+1).start) {
            while (i < intervals.size() - 1 && intervals.get(i).end >= intervals.get(i+1).start) {
                intervals.get(i).end = Math.max(intervals.get(i+1).end, intervals.get(i).end);
                intervals.remove(i+1);
            }
        }
        
        return intervals;
    }
}

