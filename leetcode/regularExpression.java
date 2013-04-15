c class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recur(s, 0, p, 0);
    }
    
    private boolean recur(String s, int is, String p, int ip) {
        // base cases
        if (ip >= p.length() && is >= s.length()) {
            return true;
        } else if (ip >= p.length() && is < s.length()) {
            return false;
        } else if (ip < p.length() && is >= s.length()) {
            return ip == p.length() - 2 && p.charAt(ip + 1) == '*';
        }
        
        if (ip == p.length() - 1) return is == s.length() - 1 && (p.charAt(ip) == s.charAt(is) || p.charAt(ip) == '.');
        
        // no *
        if (p.charAt(ip+1) != '*') {
            if (p.charAt(ip) == s.charAt(is) || p.charAt(ip) == '.')
                return recur(s, is+1, p, ip+1);
            else
                return false;
        }
        
        // with *
        //char c = s.charAt(is)
        int i = is;
        //boolean ret;
        
        for (; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(ip) || p.charAt(ip) == '.') {
                if(true == recur(s, i, p, ip + 2))
                    return true;
            } else {
                break;
            }       
        }
        
        if(true == recur(s, i, p, ip + 2)) return true;
        
        return false;
    }
}
