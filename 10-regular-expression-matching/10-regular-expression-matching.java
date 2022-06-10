class Solution {
    public boolean isMatch(String s, String p) {
        Map<String,Boolean> map = new HashMap<>();
        return checkIsMatch(s, p , 0, 0, map);
    }
    
    public boolean checkIsMatch(String s, String p, int i, int j,Map<String, Boolean> map){
        String key = i+""+j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(i >= s.length() && j >= p.length())
            return true;
        if(j >= p.length())
            return false;
        
        //System.out.println(s.charAt(i) + " " + s.charAt(j));
        boolean res= false;
        boolean match =(i < s.length() && ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.'));
        
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            boolean t1 = checkIsMatch(s,p,i,j+2,map); // dont use
            boolean t2 = (match && checkIsMatch(s,p,i+1,j,map)); //use
            res = t1 || t2;
            map.put(key,res);
            return map.get(key);
        }
        if(match){
            res = checkIsMatch(s,p,i+1,j+1,map);
            map.put(key,res) ;
            return map.get(key);
        }
        map.put(key,false);
        return false;
    }
}


/*
Base case:
1. if i== s.length and j == p.length then true
2. if j == p.length and i != s.length then false
else
Cases:
2 major cases L- . and *
1 - match = s[i] == p[j] or p[j] = "."
if p[j+1] == "*"
make a choice
use it(match && (i+1,j)) or dont use it ((i,j+2))
if match and not *
=>(i+1,j+1)
*/