import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenerateAllCombinations{
    public static void main(String args[]){
        Integer[] arr =  new Integer[]{1,2,3,4};
        List<Integer> arrList = Arrays.asList(arr);
        List<List<Integer>> result = new ArrayList<>();
        generateAllCombs(arrList,result);
        System.out.println(result.toString());
    }

    public static void generateAllCombs(List arr, List<List<Integer>> result){
        System.out.println(arr.toString());
        if(arr.size() == 0)
            result.add(new ArrayList<>());

        int firstEl = (int) (arr.get(0));
        List rest = arr.subList(1, arr.size());
        generateAllCombs(rest, result);
        for(List res : result){
            res.add(firstEl);
            result.add(res);
        }
    }
}