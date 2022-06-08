class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List> map = new HashMap<>();
        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            List<String> values = map.getOrDefault(key,new ArrayList<>());
            values.add(s);
            map.put(key,values);
        }
        for(List<String> list : map.values()){
            ans.add(list);
        }
        return ans;
    }
}