/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> v = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        v.put(node, new Node(node.val,new ArrayList<>()));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node nei: curr.neighbors){
                if(!v.containsKey(nei)){
                    v.put(nei, new Node(nei.val, new ArrayList<>()));
                    q.add(nei);
                }
                v.get(curr).neighbors.add(v.get(nei));
            }
            
        }
        return v.get(node);
    }
}