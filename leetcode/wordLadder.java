import java.lang.StringBuilder;

public class Solution {
    class Node {
        String str;
        int dist;
        public Node(String str, int dist) {
            this.str = str;
            this.dist = dist;
        }
        
    }
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> traversed = new HashSet<String>();
        LinkedList<Node> q = new LinkedList<Node>();
        int i, c;
        
        if (!dict.contains(start) || !dict.contains(end)) return 0;
        
        q.offer(new Node(start, 1));
        traversed.add(start);
        
        while (0 != q.size()) {
            Node n = q.poll();
            if (end.equals(n.str)) return n.dist;
            
            for (i = 0; i < n.str.length(); i++) {
                char rc = n.str.charAt(i);
                StringBuilder sb = new StringBuilder(n.str);
                
                for (c = 0; c < 26; c++) {
                    sb.setCharAt(i, (char)(c + 'a'));
                    String tmpstr = sb.toString();
                    sb.setCharAt(i, rc); // restore string builder
                    
                    if (!traversed.contains(tmpstr) && dict.contains(tmpstr)) {
                        if (end.equals(tmpstr)) return n.dist + 1;
                        traversed.add(tmpstr);
                        q.offer(new Node(tmpstr, n.dist + 1));
                    }
                }
            }
        }
        
        return 0;
        
    }
}
