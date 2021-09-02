import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ConnectingCitiesWithMinimumCost {
    private static int[] weights;
    private static HashMap<String,String> parents = new HashMap<>();

    //Make 1 node as parent of another
    public static void union(String a, String b){
        String s1 = parents.get(a);
        String s2 = parents.get(b);
        if(s1 == s2){
            return; 
        }
        parents.put(s1,s2);
    }

    //Find parent of a node
    public static String Find(String a){
        if(parents.get(a) != null  && !parents.get(a).equals(a)){
            parents.put(a,Find(parents.get(a)));
            //return a;
        }
        return parents.get(a);
    }

    public static void main(String[] args) {
        int num = 3;
        List<Connections> connection = new ArrayList<>();
        weights = new int[num+1];
        
        connection.add(new Connections("A","B",5));
        connection.add(new Connections("A","C",4));
        connection.add(new Connections("B","C",1));
        
        System.out.println("Input : " + connection.toString());
        System.out.println("Output : " + minimumCost(num,connection));
    }  
    
    
    public static List<Connections> minimumCost (int num,List<Connections> connection){
        List<Connections> ans = new ArrayList<>();

        for(int i = 0; i<num;i++){
            parents.put(connection.get(i).val1,connection.get(i).val1);
            weights[i] = 1;
        }
        Collections.sort(connection,( o1,  o2) -> o1.cost - o2.cost);
        int total = 0;
        int cost2 = 0;

        for(int i = 0; i< connection.size();i++){
            String a = connection.get(i).val1;
            String b = connection.get(i).val2;
            int c = connection.get(i).cost;
            if(Find(a) != Find(b)){
                cost2 += c;
                union(a,b);
                total++;
                ans.add(connection.get(i));
            }
        }
        //System.out.println(cost2);
        return total==num-1?ans:new ArrayList<>();
    } 
}

class Connections{
    String val1;
    String val2;
    int cost;

    public Connections(String val1,String val2,int cost){
        this.val1 = val1;
        this.val2 = val2;
        this.cost = cost;
    }
    
    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Connections [cost=" + cost + ", val1=" + val1 + ", val2=" + val2 + "]";
    }
    
}