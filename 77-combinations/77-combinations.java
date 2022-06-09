class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combination(result,curr,1,k,n);
        return result;
    }
    
    public void combination(List<List<Integer>> result, List<Integer> curr, int index, int k,int n){
        if(curr.size() == k)
            result.add(new ArrayList<>(curr));
        
        for(int i = index;i<=n;i++){
            curr.add(i);
            combination(result,curr,i+1,k,n);
            curr.remove(curr.size()-1);
        }
    }
}